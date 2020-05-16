package examples;

import javax.sql.DataSource;
import org.seasar.doma.SingletonConfig;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.PostgresDialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.seasar.doma.jdbc.tx.TransactionManager;

@SingletonConfig
public class DbConfig implements Config {

  private static final DbConfig CONFIG = new DbConfig();

  private final Dialect dialect;

  private final LocalTransactionDataSource dataSource;

  private final TransactionManager transactionManager;

  private DbConfig() {
    dialect = new PostgresDialect();
    dataSource =
//        new LocalTransactionDataSource("jdbc:h2:mem:tutorial;DB_CLOSE_DELAY=-1", "sa", null);
          new LocalTransactionDataSource("jdbc:postgresql://localhost:15432/doma_json", "postgres", "postgres");
    transactionManager =
        new LocalTransactionManager(dataSource.getLocalTransaction(getJdbcLogger()));
  }

  @Override
  public Dialect getDialect() {
    return dialect;
  }

  @Override
  public DataSource getDataSource() {
    return dataSource;
  }

  @Override
  public TransactionManager getTransactionManager() {
    return transactionManager;
  }

  public static DbConfig singleton() {
    return CONFIG;
  }
}
