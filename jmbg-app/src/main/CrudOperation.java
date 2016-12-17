package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.fabric.xmlrpc.base.Array;
import com.mysql.jdbc.Statement;

public class CrudOperation {
	
	private String connString = "jdbc:mysql://localhost:3306/jmbg_test?autoReconnect=true&useSSL=false";
	private String user = "root";
	private String pass = "root";
	
	public String getConnString() {
		return connString;
	}

	public void setConnString(String connString) {
		this.connString = connString;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	private String selectFromOsoba = "select osoba_ime, osoba_prezime, osoba_jmbg from osoba";
	
	public int getPerosnId(String jmbg){
		String osobaId = "select osoba_id from osoba where osoba_jmbg="+jmbg;
		int osobaid = 0;
		try {
			Connection conn = DriverManager.getConnection(connString,user,pass);
			PreparedStatement pstms = conn.prepareStatement(osobaId);
			ResultSet rs = pstms.executeQuery(osobaId);
			while (rs.next()) {
				osobaid = rs.getInt(1);
			}
			pstms.close();
			rs.close();
			conn.close();
			return osobaid;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getRegionId(String region){
		String regionBroj = "select region_id from region_rodjenja where region_broj="+region;
		int regionId = 0;
		try {
			Connection conn = DriverManager.getConnection(connString,user,pass);
			PreparedStatement pstms = conn.prepareStatement(regionBroj);
			ResultSet rs = pstms.executeQuery(regionBroj);
			while (rs.next()) {
				regionId = rs.getInt(1);
			}
			pstms.close();
			rs.close();
			conn.close();
			return regionId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void updatePerson(int id, String ime, String prezime, String jmbg, int region){
		
		String update = "update osoba set osoba_ime=?, osoba_prezime=?, osoba_jmbg=?, region_id=? where osoba_id=?";
		int regionId = getRegionId(String.valueOf(region));
		
		try {
			Connection conn = DriverManager.getConnection(connString,user,pass);
			PreparedStatement pstms = conn.prepareStatement(update);
			pstms.setString(1, ime);
			pstms.setString(2, prezime);
			pstms.setString(3, jmbg);
			pstms.setInt(4, regionId);
			pstms.setInt(5, id);
			pstms.execute();
			pstms.close();
			conn.close();
			JOptionPane.showMessageDialog(null,
					"Uspešno ste izvršili izmene", "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(ime+" "+id+" "+regionId+" "+prezime);
	}
	
	public void deletePerson(String jmbg){
		String delete = "delete from osoba where osoba_jmbg ="+jmbg;
		
		try {
			Connection conn = DriverManager.getConnection(connString,user,pass);
			
			PreparedStatement pstms = conn.prepareStatement(delete);
			pstms.executeUpdate(delete);
			pstms.close();
			conn.close();
			JOptionPane.showMessageDialog(null,
					"Uspešno ste obrisali osobu", "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isJmbg(String jmbg){
		
		try {
			Connection conn = DriverManager.getConnection(connString,user,pass);
			PreparedStatement pstms = conn.prepareStatement("select osoba_jmbg from osoba");
			ResultSet rs = pstms.executeQuery("select osoba_jmbg from osoba");
			while(rs.next()){
				if(jmbg.equalsIgnoreCase(rs.getString(1))){
					return false;
				}
			}
			pstms.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(true);
		return true;
	}
	
	public void insertPerson(String ime, String prezime, String jmbg){
		
		int z = Integer.parseInt(String.valueOf(jmbg.charAt(7)));
		int zz = Integer.parseInt(String.valueOf(jmbg.charAt(8)));
		String region = String.valueOf(z)+String.valueOf(zz);
		System.out.println(region);
		String insert = "insert into osoba (osoba_ime, osoba_prezime, osoba_jmbg, region_id)"
						+" values (?,?,?,?)";
		
		int regionId = getRegionId(region);
		System.out.println(regionId);
			try {
				Connection conn = DriverManager.getConnection(connString,user,pass);
				PreparedStatement pstms = conn.prepareStatement(insert);
				pstms.setString(1, ime);
				pstms.setString(2, prezime);
				pstms.setString(3, jmbg);
				pstms.setInt(4, regionId);
				pstms.execute();
				pstms.close();
				conn.close();
					JOptionPane.showMessageDialog(null,
							"Uspesno ste uneli osobu", "Obavestenje",
							JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public DefaultTableModel getAllData() {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("IME");
		dtm.addColumn("PREZIME");
		dtm.addColumn("JMBG");

		try {
			Connection conn = DriverManager.getConnection(connString, user, pass);

			PreparedStatement pstms = conn.prepareStatement(selectFromOsoba);
			ResultSet rs = pstms.executeQuery(selectFromOsoba);

			while (rs.next()) {

				String ime = rs.getString(1);
				String prezime = rs.getString(2);
				String jmbg = rs.getString(3);
				dtm.addRow(new String[] { ime, prezime, jmbg });

			}
			pstms.close();
			rs.close();
			conn.close();
			return dtm;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public String getRegion(String region){
		String r = null;
		String selectRegion = "select region_naziv from region_rodjenja where region_broj="+"'"+region+"'";
		try{
			Connection conn = DriverManager.getConnection(connString,user,pass);
			PreparedStatement pstms = conn.prepareStatement(selectRegion);
			ResultSet rs = pstms.executeQuery(selectRegion);
			while(rs.next()){
				r = rs.getString(1);
			}
			pstms.close();
			rs.close();
			conn.close();
			return r;
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public String getDrzava(String region){
		String r = null;
		String selectDrzava = "select drzava_naziv from region_rodjenja where region_broj="+"'"+region+"'";
		try{
			Connection conn = DriverManager.getConnection(connString,user,pass);
			PreparedStatement pstms = conn.prepareStatement(selectDrzava);
			ResultSet rs = pstms.executeQuery(selectDrzava);
			while(rs.next()){
				r = rs.getString(1);
			}
			pstms.close();
			rs.close();
			conn.close();
			return r;
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
}
