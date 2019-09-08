
/**
 * This class represents a simple particle as an implementation of the particle interface. The
 * person has both an x and a y coordinate as well as velocity components for both the x and y
 * axis.
 */

public class SimpleProjectile implements Particle {

  public static final String FORMAT = "At time %.2f: position is (%.2f,%.2f)";
  private static final float g = 9.81f;
  private float x;
  private float y;
  private float vx;
  private float vy;

  /**
   * Construct a simple projectile object that has the x/y coordinates and the vx,vy velocity
   * components.
   *
   * @param x  the initial x coordinate
   * @param y  the initial y coordinate
   * @param vx the initial velocity in the x axis
   * @param vy the initial velocity in the y axis
   */
  public SimpleProjectile(float x, float y, float vx, float vy) {
    this.x = x;
    this.y = y;
    this.vx = vx;
    this.vy = vy;
  }

  /**
   * Return the x coordinate of the simple particle.
   *
   * @return the x coordinate of the simple particle.
   */
  public float getX() {
    return this.x;
  }

  /**
   * Return the y coordinate of the simple particle.
   *
   * @return the y coordinate of the simple particle.
   */
  public float getY() {
    return this.y;
  }

  /**
   * Return the velocity in the x axis of the simple particle.
   *
   * @return the velocity in the x axis of the simple particle.
   */
  public float getXComponent() {
    return this.vx;
  }

  /**
   * Return the velocity in the y axis of the simple particle.
   *
   * @return the velocity in the y axis of the simple particle.
   */
  public float getYComponent() {
    return this.vy;
  }

  /**
   * Return the state of this particle as a formatted string. The format of the string is as
   * follows: At time [t]: position is ([x],[y]) where
   * <ul>
   * <li>[t] is the time passed to this method, rounded to two decimal
   * places</li>
   * <li>[x] is the x-coordinate of the position of this particle at this
   * time, rounded to two decimal places </li>
   * <li>[y] is the y-coordinate of the position of this particle at this
   * time, rounded to two decimal places
   * </li> </ul>
   *
   * @param time the time at which the state must be obtained
   * @return the state of the particle as a string formatted as above
   */
  public String getState(float time) {

    // Handling of negative time
    if (time <= 0f) {
      return String.format(FORMAT, time, this.x, this.y);
    }
    // Calculation of maximum time of flight for if the given time is greater */
    float initialTime = time;
    float timeOfFlight = (2 * vy) / g;
    //Handling time being greater than time of flight
    if (time > timeOfFlight) {
      time = timeOfFlight;
    }
    //Calculation of position
    float x = this.vx * time + this.x;
    float y = this.vy * time + .5f * -g * (float) Math.pow(time, 2) + this.y;

    return String.format(FORMAT, initialTime, x, y);
  }

}
