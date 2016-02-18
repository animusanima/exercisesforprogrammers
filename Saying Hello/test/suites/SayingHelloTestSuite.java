package suites;

import host.SayingHelloTests;
import domain.EnglishGreetingTest;
import domain.GermanGreetingTest;
import domain.SpanishGreetingTest;
import presentation.ConsoleUserInterfaceTest;
import persistency.InMemoryGreetingsRepositoryTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({SayingHelloTests.class, EnglishGreetingTest.class, GermanGreetingTest.class, SpanishGreetingTest.class, ConsoleUserInterfaceTest.class, InMemoryGreetingsRepositoryTest.class})
public class SayingHelloTestSuite { }
