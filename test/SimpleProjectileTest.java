import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleProjectileTest {
  private SimpleProjectile verticalParticle, rightProjectile, leftProjectile, nonOriginParticle;

  @Before
  public void setUp() {

    verticalParticle = new SimpleProjectile(0f, 0f, 0f,10f);
    rightProjectile = new SimpleProjectile(0f, 0f, 5f,10f);
    leftProjectile = new SimpleProjectile(0f, 0f, -5f,10f);
    nonOriginParticle = new SimpleProjectile(-6f, 4f, 5f,10f);

  }

  @Test
  public void testVertical() {

    float time = 2.0387f;
    float x = .0f;
    float y = .0f;

    assertEquals(String.format(SimpleProjectile.format,time,x,y,time,x,y), verticalParticle.getState(time));
  }

  @Test
  public void testBeyondGround() {
    assertEquals(String.format(SimpleProjectile.format,time,x,y,time,x,y), verticalParticle.getState(5f));
  }

  @Test
  public void testRight() {
    assertEquals("(10.00,0.38)", rightProjectile.getState(2f));
  }

  @Test
  public void testLeft() {
    assertEquals("(-10.00,0.38)", leftProjectile.getState(2f));
  }

  @Test
  public void testNegativeTime() {
    assertEquals(String.format("(%.2f,%.2f)",verticalParticle.GetX(),verticalParticle.GetY()), verticalParticle.getState(-2f));
  }

  @Test
  public void testNegativeTime2() {
    assertEquals(String.format("(%.2f,%.2f)",nonOriginParticle.GetX(),nonOriginParticle.GetY()), nonOriginParticle.getState(-2f));
  }

}