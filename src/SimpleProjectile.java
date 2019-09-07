
/**
 * This class represents a simple particle as an implementation of the particle interface.
 * The person has both an x and a y coordinate as well as velocity components for both the x and y axis.
 */

public class SimpleProjectile implements Particle {

  private float x,y,vx,vy;
  private static final float g = -9.81f;
  public static final String format = "At time [%.2f]: position is ([%.2f],[%.2f])</code> where\n" +
          "<ul>\n" +
          "<li>[%.2f] is the time passed to this method, rounded to two decimal\n" +
          "places</li>\n" +
          "<li>[%.2f] is the x-coordinate of the position of this particle at this\n" +
          "time, rounded to two decimal places </li>\n" +
          "<li>[%.2f] is the y-coordinate of the position of this particle at this\n" +
          "time, rounded to two decimal places\n" +
          "</li> </ul>";

  /**
   * Construct a simple projectile object that has the x/y coordinates and the vx,vy velocity components.
   *
   * @param x  the initial x coordinate
   * @param y the initial y coordinate
   * @param vx the initial velocity in the x axis
   * @param vy the initial velocity in the y axis
   */
  public SimpleProjectile (float x, float y, float vx, float vy){
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
  public float GetX () {
    return this.x;
  }

  /**
   * Return the y coordinate of the simple particle.
   *
   * @return the y coordinate of the simple particle.
   */
  public float GetY (){
    return this.y;
  }

  /**
   * Return the velocity in the x axis of the simple particle.
   *
   * @return the velocity in the x axis of the simple particle.
   */
  public float GetXComponent(){
    return this.vx;
  }

  /**
   * Return the velocity in the y axis of the simple particle.
   *
   * @return the velocity in the y axis of the simple particle.
   */
  public float GetYComponent(){
    return this.vy;
  }

  /**
   * Return the state of this particle as a formatted string. The format of the string is as
   * follows:
   * At time [t]: position is ([x],[y])</code> where
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
  public String getState(float time){

    if (time <= 0f) return String.format("(%.2f,%.2f)",this.x,this.y);

    float x = this.vx*time + this.x;
    float y = this.vy*time + .5f*g*(float)Math.pow(time,2) + this.y;

    if (y < 0f) y = 0f;

    return String.format(format,time,x,y,time,x,y);
  }
}
