package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.dao.AddressDao;
import com.techelevator.model.pojo.Address;

@Component
public class JdbcAddressDao implements AddressDao {
	
	private JdbcTemplate jdbc;

	@Autowired
	public JdbcAddressDao(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Address getAddress(long addressID, long userID) {
		String sqlString = "SELECT address_id, street_address, city, state, zip, user_id "
						+ "FROM address "
						+ "WHERE address_id = ?";
		
		SqlRowSet results = jdbc.queryForRowSet(sqlString, addressID);
		
		Address address = null;
		
		if( results.next() ) {
			address = mapRowToAddress(results);
		}
		
		return address;
	}
	
	public Address createAddress(Address address) {
		String sqlQuery = "INSERT INTO address (street_address, city, state, zip, user_id) "
				 + "VALUES (?, ?, ?, ?, ?) RETURNING address_id";
		long addressId = jdbc.queryForObject(sqlQuery, Long.class,
							address.getStreetAddress(),
							address.getCity(),
							address.getState(),
							address.getZip(),
							address.getUserId());
		
		address.setAddressId(addressId);
		
		return address;
	}
	
	public List<Address> getAddressesForUser(long userID) {
		String sqlString = "SELECT address_id, street_address, city, state, zip, user_id "
						 + "FROM address "
						 + "WHERE user_id = ?";
		
		SqlRowSet results = jdbc.queryForRowSet(sqlString, userID);
		
		List<Address> addresses = new ArrayList<>();
		
		while( results.next() ) {
			addresses.add(mapRowToAddress(results));
		}
		
		return addresses;
	}
	
	private Address mapRowToAddress(SqlRowSet row) {
		Address address = new Address();
		
		address.setAddressId(row.getLong("address_id"));
		address.setStreetAddress(row.getString("street_address"));
		address.setCity(row.getString("city"));
		address.setState(row.getString("state"));
		address.setZip(row.getString("zip"));
		address.setUserId(row.getLong("user_id"));
		
		return address;
	}
}
