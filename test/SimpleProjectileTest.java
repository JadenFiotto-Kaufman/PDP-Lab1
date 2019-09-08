import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for the SimpleParticle class.
 */
public class SimpleProjectileTest {

  private SimpleProjectile verticalParticle;
  private SimpleProjectile rightProjectile;
  private SimpleProjectile leftProjectile;
  private SimpleProjectile nonOriginParticle;

  @Before
  public void setUp() {

    verticalParticle = new SimpleProjectile(0f, 0f, 0f, 10f);
    rightProjectile = new SimpleProjectile(0f, 0f, 5f, 10f);
    leftProjectile = new SimpleProjectile(0f, 0f, -5f, 10f);
    nonOriginParticle = new SimpleProjectile(-6f, 4f, 5f, 10f);

  }

  @Test
  public void testVertical() {

    float time = 2.0387f;
    float x = .0f;
    float y = .0f;

    assertEquals(String.format(SimpleProjectile.FORMAT, time, x, y),
            verticalParticle.getState(time));
  }

  @Test
  public void testBeyondGround() {

    float time = 5f;
    float x = .0f;
    float y = .0f;

    assertEquals(String.format(SimpleProjectile.FORMAT, time, x, y),
            verticalParticle.getState(time));
  }

  @Test
  public void testBeyondGround2() {

    float time = 6f;
    float x = 10.19f;
    float y = .0f;

    assertEquals(String.format(SimpleProjectile.FORMAT, time, x, y),
            rightProjectile.getState(time));
  }

  @Test
  public void testRight() {

    float time = 2f;
    float x = 10f;
    float y = .38f;

    assertEquals(String.format(SimpleProjectile.FORMAT, time, x, y),
            rightProjectile.getState(time));
  }

  @Test
  public void testLeft() {

    float time = 2f;
    float x = -10f;
    float y = .38f;

    assertEquals(String.format(SimpleProjectile.FORMAT, time, x, y),
            leftProjectile.getState(time));
  }

  @Test
  public void testNegativeTime() {

    float time = -2f;
    float x = verticalParticle.getX();
    float y = verticalParticle.getY();

    assertEquals(String.format(SimpleProjectile.FORMAT, time, x, y),
            verticalParticle.getState(time));
  }

  @Test
  public void testNegativeTime2() {

    float time = -2f;
    float x = nonOriginParticle.getX();
    float y = nonOriginParticle.getY();

    assertEquals(String.format(SimpleProjectile.FORMAT, time, x, y),
            nonOriginParticle.getState(time));
  }

}