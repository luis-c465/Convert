package luisc;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

/**
 * Class whitch assetses images and audio to be played back
 * in the game
 *
 * Call the _setup method to load all the images and the sounds
 */
public class Assets {

  public PApplet p;
  public Class _class;

  // * BUTTONS
  public PImage enter;
  public PImage space;

  // * MISCELLANEOUS
  public PImage bg;

  // * FONTS
  public PFont nunito;
  // !Smaller versions of fonts are loaded because controlP5 does not give a method to set the font size of the input text
  public PFont nunito_small;

  public void setup(App app) {
    this.p = app;
    this._class = this.getClass();

    // * LOAD BUTTONS
    enter = p.loadImage("btn/enter.png");
    space = p.loadImage("btn/space.png");
    space.resize(200, 100);

    // * LOAD MISC
    bg = p.loadImage("bg-blur.jpg");

    // * LOAD FONTS
    nunito = p.createFont("fonts/Nunito.ttf", 64);
    nunito_small = p.createFont("fonts/Nunito.ttf", 32);
    p.textFont(nunito);
  }

  /**
   * Safely and dynamically get an asset with the given name
   */
  public PImage getAsset(String name) {
    try {
      return (PImage) get(name);
    } catch (Exception e) {
      return null;
    }
  }

  public Object get(String k) throws IllegalAccessException, NoSuchFieldException {
    return (_class.getDeclaredField(k).get(this));
  }
}
