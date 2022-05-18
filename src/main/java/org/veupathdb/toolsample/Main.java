package org.veupathdb.toolsample;

import org.gusdb.fgputil.db.platform.SupportedPlatform;
import org.gusdb.fgputil.db.pool.DatabaseInstance;
import org.gusdb.fgputil.db.pool.SimpleDbConfig;
import org.gusdb.fgputil.db.runner.SQLRunner;

public class Main {

  public static void main(String args[]) throws Exception {

    // sample takes connection arguments via command line
    if (args.length != 3) {
      System.err.println("Requires three arguments: <connectionUrl> <connectionUser> <connectionPassword>");
      System.exit(1);
    }

    // read args
    String connectionUrl = args[0];
    String connectionUser = args[1];
    String connectionPassword = args[2];

    // instantiate a connection to the database
    try (DatabaseInstance db = new DatabaseInstance(SimpleDbConfig.create(
        SupportedPlatform.ORACLE, connectionUrl, connectionUser, connectionPassword))) {

      // do some db work here
      new SQLRunner(db.getDataSource(), "select 1 from dual").executeQuery(rs -> null);

      System.out.println("Done.");
    }
  }
}
