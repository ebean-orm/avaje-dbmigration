package io.ebean.migration.runner;

import io.ebean.ddlrunner.DdlAutoCommit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MigrationPlatformTest {

  final DdlAutoCommit pg = DdlAutoCommit.POSTGRES;

  @Test
  public void transaction_false() {
    assertFalse(pg.transactional("create index concurrently foo"));
    assertFalse(pg.transactional("drop index concurrently foo"));
    assertFalse(pg.transactional("CREATE INDEX CONCURRENTLY foo"));
    assertFalse(pg.transactional("DROP INDEX CONCURRENTLY foo"));
  }

  @Test
  public void transaction_true() {
    assertTrue(pg.transactional("create index foo"));
    assertTrue(pg.transactional("drop index foo"));
    assertTrue(pg.transactional("CREATE INDEX foo"));
    assertTrue(pg.transactional("DROP INDEX foo"));
  }
}