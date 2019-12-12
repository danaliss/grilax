package com.techelevator.integrationtests;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public abstract class DaoIntegrationTest {

	/*
	 * Using this particular implementation of DataSource so that every database
	 * interaction is part of the same database session and hence the same database
	 * transaction
	 */
	private static SingleConnectionDataSource dataSource;

	private JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
	protected Long testFoodId1;
	protected Long testFoodId2;
	protected Long testOrderId;
	protected Long testUserId;
	protected Long testEventId1;
	protected Long testEventId2;
	protected Long testAddressId;

	/*
	 * Before any tests are run, this method initializes the datasource for testing.
	 */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/cookoutdb");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/*
		 * The following line disables autocommit for connections returned by this
		 * DataSource. This allows us to rollback any changes after each test
		 */
		dataSource.setAutoCommit(false);
	}

	/*
	 * After all tests have finished running, this method will close the DataSource
	 */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	/*
	 * Before each test, we insert data into the tables of our database so we won't
	 * have to rely on data already being there
	 */
	@Before
	public void setup() {
		String sql = "INSERT INTO address (street_address, city, state, zip) "
				   + "VALUES ('1337 Very Fake Street', 'Boston', 'MA', '02134') RETURNING address_id";

	    testAddressId = jdbcTemplate.queryForObject(sql, Long.TYPE);
		
		sql = "INSERT INTO event (event_name, event_date, event_time, description, deadline, address_id) "
		    + "VALUES ('Summer Cookout 2020', '07-05-2020', '3pm', 'Partying after the 4th of July!', '06-28-2020', 1) RETURNING event_id";

		testEventId1 = jdbcTemplate.queryForObject(sql, Long.TYPE);

		sql = "INSERT INTO event (event_name, event_date, event_time, description, deadline, address_id) "
			+ "VALUES ('Fibonacci Day Party', '11-23-2020', '5pm', 'Celebrate Fibonacci Day!', '11-16-2020', 1) RETURNING event_id";

		testEventId2 = jdbcTemplate.queryForObject(sql, Long.TYPE);
		
		sql = "INSERT INTO users (username, password, salt, email, date_registered) "
			+ "VALUES ('FakeUser', 'FakePassword', 'FAKESALT', 'Fake@Fake.com', '2019-12-11 17:26:30') RETURNING user_id";

		testUserId = jdbcTemplate.queryForObject(sql, Long.TYPE);
		
		sql = "INSERT INTO food (food_name, vegetarian, vegan, gluten_free, " 
		    + "nut_free, description, event_id) "
			+ "VALUES ('Grilled Chicken', 'false', 'false', 'true', 'true', "
			+ "'Marinated grilled chicken', 1) RETURNING food_id";

		testFoodId1 = jdbcTemplate.queryForObject(sql, Long.TYPE);

		sql = "INSERT INTO food (food_name, vegetarian, vegan, gluten_free, " 
		    + "nut_free, description, event_id) "
			+ "VALUES ('Grilled Tofu', 'true', 'true', 'true', 'true', "
			+ "'Marinated grilled tofu', 1) RETURNING food_id";

		testFoodId2 = jdbcTemplate.queryForObject(sql, Long.TYPE);
		
		sql = "INSERT INTO orders (event_id, user_id, food_id, status, quantity) "
			+ "VALUES ('1', '1', '1', 'waiting', '2') RETURNING order_id";

		testOrderId = jdbcTemplate.queryForObject(sql, Long.TYPE);
	}

	/*
	 * After each test, we rollback any changes that were made to the database so
	 * that everything is clean for the next test
	 */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	/*
	 * This method provides access to the DataSource for subclasses so that they can
	 * instantiate a DAO for testing
	 */
	public DataSource getDataSource() {
		return dataSource;
	}
}
