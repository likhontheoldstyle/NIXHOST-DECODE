package a;

public final class ImageTextOverlay {

    public String text;

    public float x = 0.0f;

    public float y;

    public float textSize;

    public final int color;

    public ImageTextOverlay(String str, float f2, float f3, int i2) {
        this.text = str;
        this.y = f2;
        this.textSize = f3;
        this.color = i2;
    }
}
