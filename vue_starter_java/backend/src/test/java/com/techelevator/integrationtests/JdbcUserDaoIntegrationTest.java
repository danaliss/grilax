package com.techelevator.integrationtests;

import org.junit.Test;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.junit.Assert;

import com.techelevator.model.pojo.Food;
import com.techelevator.model.pojo.User;

public class JdbcUserDaoIntegrationTest extends DaoIntegrationTest {

	@Test
	public void saveUser_creates_new_user() {

		//User testUser = getUserById(testUserId);
		//userDao.saveUser(testUser.getUsername(), testUser.getPassword(), testUser.getRole(), testUser.getEmail());
		userDao.saveUser("Fake", "fake", "user", "Fake@Fake.com");
		
	}
	
	 private User mapResultToUser(SqlRowSet results) {
	        User user = new User();
	        user.setId(results.getLong("user_id"));
	        user.setUsername(results.getString("username"));
	        user.setEmail(results.getString("email"));
	        user.setRole(results.getString("role"));
	        return user;
	    }
	 
	 private User getUserById(long userId) {
			String sqlQuery = "SELECT user_id, username, email, role FROM users WHERE user_id=?";

			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, userId);

			User user = null;
			if (results.next()) {
				user = mapResultToUser(results);
			}
			return user;
		}
}
