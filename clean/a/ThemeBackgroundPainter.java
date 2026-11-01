package a;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import java.util.HashMap;
import java.util.Random;

public abstract class ThemeBackgroundPainter {

    public static final HashMap bitmapCache = new HashMap();

    public static int toColorInt(long j2) {
        return (int) j2;
    }

    public static void drawBackground(ChatTheme theme, Canvas canvas, float width, float height) {
        Canvas canvas2;
        float f4 = 0.13f;
        boolean z = true;
        Paint paint = new Paint(1);
        float f5 = width / 360.0f;
        String str = theme.id;
        switch (str.hashCode()) {
            case -2132535343:
                canvas2 = canvas;
                if (str.equals("spectrum")) {
                    fillVerticalGradient(canvas, paint, width, height, new int[]{toColorInt(4279916031L), toColorInt(4287234303L), toColorInt(4294912811L)}, new float[]{0.0f, 0.55f, 1.0f});
                    drawGlowCircle(width * 0.8f, height * 0.15f, width * 0.6f, 862367999, canvas, paint);
                    break;
                }
                canvas2.drawColor(theme.statusBarColor);
                break;
            case -2126423541:
                if (str.equals("lollipop")) {
                    fillVerticalGradient(canvas, paint, width, height, new int[]{toColorInt(4289257435L), toColorInt(4288731348L)}, null);
                    Paint paint2 = paint;
                    float[][] fArr = {new float[]{0.2f, 0.09f, -30.0f, 0.0f}, new float[]{0.78f, 0.07f, 12.0f, 1.0f}, new float[]{0.05f, 0.24f, 30.0f, 1.0f}, new float[]{0.5f, 0.2f, -50.0f, 0.0f}, new float[]{0.88f, 0.28f, 20.0f, 1.0f}, new float[]{0.3f, 0.34f, -20.0f, 0.0f}, new float[]{0.7f, 0.42f, 35.0f, 0.0f}, new float[]{0.1f, 0.5f, 10.0f, 1.0f}, new float[]{0.45f, 0.52f, -35.0f, 1.0f}, new float[]{0.9f, 0.6f, -25.0f, 0.0f}, new float[]{0.25f, 0.68f, 40.0f, 0.0f}, new float[]{0.62f, 0.7f, 8.0f, 1.0f}, new float[]{0.05f, 0.86f, -40.0f, 1.0f}, new float[]{0.4f, 0.88f, 25.0f, 0.0f}, new float[]{0.85f, 0.85f, -15.0f, 1.0f}};
                    int i2 = 0;
                    while (i2 < 15) {
                        float[] fArr2 = fArr[i2];
                        float f6 = fArr2[0] * width;
                        float f7 = fArr2[1] * height;
                        float f8 = width * 0.052f;
                        canvas.save();
                        canvas.translate(f6, f7);
                        canvas.rotate(fArr2[2]);
                        Paint paint3 = paint2;
                        paint3.setStyle(Paint.Style.STROKE);
                        paint3.setStrokeCap(Paint.Cap.ROUND);
                        paint3.setStrokeWidth(0.014f * width);
                        paint3.setColor(toColorInt(4294175699L));
                        canvas.drawLine(0.0f, f8 * 0.8f, 0.0f, f8 * 4.2f, paint3);
                        paint3.setStyle(Paint.Style.FILL);
                        boolean z2 = fArr2[3] > 0.5f;
                        float f9 = -f8;
                        float f10 = f9 * 0.3f;
                        paint3.setShader(new RadialGradient(f10, f10, f8 * 1.5f, toColorInt(z2 ? 4294947812L : 4286310094L), toColorInt(z2 ? 4294080454L : 4280268954L), Shader.TileMode.CLAMP));
                        canvas.drawCircle(0.0f, 0.0f, f8, paint3);
                        paint3.setShader(null);
                        paint3.setColor(1728053247);
                        canvas.drawCircle(f9 * 0.35f, f9 * 0.4f, f8 * 0.22f, paint3);
                        canvas.restore();
                        i2++;
                        paint2 = paint3;
                    }
                    break;
                }
                canvas2 = canvas;
                canvas2.drawColor(theme.statusBarColor);
                break;
            case -2112790606:
                if (str.equals("cottagecore")) {
                    fillVerticalGradient(canvas, paint, width, height, new int[]{toColorInt(4292278015L), toColorInt(4293524463L), toColorInt(4289323646L), toColorInt(4290046116L)}, new float[]{0.0f, 0.22f, 0.5f, 1.0f});
                    Random random = new Random(3L);
                    int i3 = 0;
                    while (i3 < 2) {
                        float f11 = (i3 == 0 ? 0.3f : 0.36f) * height;
                        paint.setColor(toColorInt(i3 == 0 ? 4285516650L : 4283282266L));
                        float f12 = (-width) * 0.05f;
                        while (f12 < 1.05f * width) {
                            float nextFloat = ((random.nextFloat() * 0.04f) + 0.07f) * width;
                            Path path = new Path();
                            path.moveTo(f12, f11);
                            path.lineTo((nextFloat / 2.0f) + f12, f11 - (2.1f * nextFloat));
                            path.lineTo(f12 + nextFloat, f11);
                            path.close();
                            canvas.drawPath(path, paint);
                            f12 += nextFloat * 0.7f;
                        }
                        i3++;
                    }
                    paint.setColor(toColorInt(4288338058L));
                    float f13 = -width;
                    float f14 = height * 0.7f;
                    canvas.drawOval(new RectF(f13 * 0.3f, height * 0.34f, 1.3f * width, f14), paint);
                    paint.setColor(toColorInt(4289323930L));
                    float f15 = height * 0.55f;
                    canvas.drawOval(new RectF(f13 * 0.2f, f15, 1.2f * width, 1.1f * height), paint);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeCap(Paint.Cap.ROUND);
                    Path path2 = new Path();
                    float f16 = width * 0.5f;
                    path2.moveTo(f16, height * 0.36f);
                    path2.cubicTo(width * 0.45f, height * 0.45f, width * 0.7f, height * 0.5f, width * 0.62f, height * 0.6f);
                    path2.cubicTo(width * 0.55f, f14, width * 0.2f, f14, width * 0.15f, height * 0.9f);
                    float f17 = width * 0.08f;
                    paint.setStrokeWidth(f17);
                    paint.setColor(toColorInt(2864222830L));
                    canvas.drawPath(path2, paint);
                    paint.setStyle(Paint.Style.FILL);
                    float f18 = height * 0.35f;
                    paint.setColor(toColorInt(4293515944L));
                    float f19 = width * 0.07f;
                    float f20 = f16 + f19;
                    canvas.drawRect(f16 - f19, f18 - (height * 0.04f), f20, f18, paint);
                    paint.setColor(toColorInt(4286356060L));
                    Path path3 = new Path();
                    float f21 = width * 0.09f;
                    float f22 = f18 - (0.035f * height);
                    path3.moveTo(f16 - f21, f22);
                    path3.lineTo(f16, f18 - (0.075f * height));
                    path3.lineTo(f21 + f16, f22);
                    path3.close();
                    canvas.drawPath(path3, paint);
                    paint.setColor(toColorInt(4287261258L));
                    float f23 = 0.012f * width;
                    canvas.drawRect(f16 - f23, f18 - (0.022f * height), f16 + f23, f18, paint);
                    paint.setColor(toColorInt(4288663784L));
                    float f24 = width * 0.055f;
                    float f25 = f18 - (0.033f * height);
                    float f26 = width * 0.03f;
                    float f27 = f18 - (height * 0.018f);
                    canvas.drawRect(f16 - f24, f25, f16 - f26, f27, paint);
                    canvas.drawRect(f16 + f26, f25, f16 + f24, f27, paint);
                    paint.setColor(toColorInt(2868903935L));
                    canvas.drawCircle((width * 0.05f) + f16, f18 - (height * 0.1f), 0.014f * width, paint);
                    canvas.drawCircle(f20, f18 - (height * 0.12f), width * 0.018f, paint);
                    paint.setColor(toColorInt(4286366842L));
                    float f28 = width * 0.1f;
                    canvas.drawCircle(width * 0.78f, f14, f28, paint);
                    canvas.drawCircle(width * 0.9f, 0.73f * height, f17, paint);
                    canvas.drawCircle(f28, f15, f19, paint);
                    int[] iArr = {toColorInt(4294967295L), toColorInt(4294288327L), toColorInt(4294959738L), toColorInt(4291404789L)};
                    for (int i4 = 0; i4 < 40; i4++) {
                        paint.setColor(iArr[random.nextInt(4)]);
                        canvas.drawCircle(random.nextFloat() * width, ((random.nextFloat() * 0.45f) + 0.5f) * height, ((random.nextFloat() * 2.5f) + 2.0f) * f5, paint);
                    }
                    break;
                }
                canvas2 = canvas;
                canvas2.drawColor(theme.statusBarColor);
                break;
            case -2041009430:
                if (str.equals("celebration")) {
                    fillVerticalGradient(canvas, paint, width, height, new int[]{toColorInt(4294942832L), toColorInt(4294155202L), toColorInt(4292046806L), toColorInt(4291321035L)}, new float[]{0.0f, 0.35f, 0.75f, 1.0f});
                    drawGlowCircle(width * 0.28f, height * 0.1f, width * 0.55f, toColorInt(2298470576L), canvas, paint);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeCap(Paint.Cap.ROUND);
                    Path path4 = new Path();
                    float f29 = (-width) * 0.1f;
                    path4.moveTo(f29, height * 0.36f);
                    float f30 = width * 1.1f;
                    path4.cubicTo(width * 0.3f, height * 0.22f, width * 0.65f, height * 0.5f, f30, height * 0.34f);
                    paint.setStrokeWidth(0.11f * width);
                    paint.setColor(1435131104);
                    canvas.drawPath(path4, paint);
                    paint.setStrokeWidth(0.035f * width);
                    paint.setColor(1728053247);
                    canvas.drawPath(path4, paint);
                    Path path5 = new Path();
                    path5.moveTo(f29, height * 0.7f);
                    path5.cubicTo(width * 0.25f, height * 0.6f, width * 0.6f, height * 0.82f, f30, height * 0.62f);
                    paint.setStrokeWidth(width * 0.09f);
                    paint.setColor(1148865752);
                    canvas.drawPath(path5, paint);
                    paint.setStyle(Paint.Style.FILL);
                    Random random2 = new Random(7L);
                    int[] iArr2 = {2013265919, 1720605920, 1728039056, 1727045848, 1442840575};
                    for (int i5 = 0; i5 < 70; i5++) {
                        float nextFloat2 = random2.nextFloat() * width;
                        float nextFloat3 = random2.nextFloat() * height;
                        float nextFloat4 = ((random2.nextFloat() * 20.0f) + 5.0f) * f5;
                        paint.setColor(iArr2[random2.nextInt(5)]);
                        canvas.save();
                        canvas.rotate(random2.nextFloat() * 180.0f, nextFloat2, nextFloat3);
                        float f31 = nextFloat4 * 0.65f;
                        canvas.drawOval(new RectF(nextFloat2 - nextFloat4, nextFloat3 - f31, nextFloat2 + nextFloat4, nextFloat3 + f31), paint);
                        canvas.restore();
                    }
                    break;
                }
                canvas2 = canvas;
                canvas2.drawColor(theme.statusBarColor);
                break;
            case -1723892108:
                if (str.equals("astrology")) {
                    fillVerticalGradient(canvas, paint, width, height, new int[]{toColorInt(4294964637L), toColorInt(4294948685L), toColorInt(4294222458L), toColorInt(4294957480L)}, new float[]{0.0f, 0.28f, 0.62f, 1.0f});
                    float f32 = width * 0.5f;
                    float f33 = height * 0.3f;
                    drawGlowCircle(f32, f33, width * 0.62f, toColorInt(2868895874L), canvas, paint);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeCap(Paint.Cap.ROUND);
                    paint.setStrokeWidth(f5 * 1.4f);
                    paint.setColor(toColorInt(2583688112L));
                    int i6 = 0;
                    while (i6 < 48) {
                        double radians = Math.toRadians(i6 * 7.5d);
                        double d2 = width * f4;
                        float f34 = f32;
                        double d3 = (i6 % 2 == 0 ? 0.3f : 0.22f) * width;
                        canvas.drawLine(((float) (Math.cos(radians) * d2)) + f32, ((float) (Math.sin(radians) * d2)) + f33, f34 + ((float) (Math.cos(radians) * d3)), f33 + ((float) (Math.sin(radians) * d3)), paint);
                        i6++;
                        f32 = f34;
                        f4 = 0.13f;
                    }
                    float f35 = f32;
                    float[][] fArr3 = {new float[]{0.08f, 0.1f, 0.18f, 0.16f, 0.26f, 0.12f, 0.31f, 0.2f}, new float[]{0.7f, 0.08f, 0.78f, 0.14f, 0.88f, 0.1f, 0.94f, 0.19f}, new float[]{0.06f, 0.4f, 0.14f, 0.46f, 0.12f, 0.55f, 0.22f, 0.6f}, new float[]{0.8f, 0.42f, 0.9f, 0.48f, 0.84f, 0.57f, 0.93f, 0.62f}, new float[]{0.3f, 0.52f, 0.4f, 0.58f, 0.5f, 0.54f, 0.62f, 0.6f}};
                    paint.setStrokeWidth(1.2f * f5);
                    paint.setColor(toColorInt(2868898216L));
                    for (int i7 = 0; i7 < 5; i7++) {
                        float[] fArr4 = fArr3[i7];
                        int i8 = 0;
                        while (true) {
                            int i9 = i8 + 3;
                            if (i9 < fArr4.length) {
                                int i10 = i8 + 2;
                                canvas.drawLine(fArr4[i8] * width, fArr4[i8 + 1] * height, fArr4[i10] * width, fArr4[i9] * height, paint);
                                i8 = i10;
                            }
                        }
                    }
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(toColorInt(3724539592L));
                    for (int i11 = 0; i11 < 5; i11++) {
                        float[] fArr5 = fArr3[i11];
                        int i12 = 0;
                        while (true) {
                            int i13 = i12 + 1;
                            if (i13 < fArr5.length) {
                                canvas.drawCircle(fArr5[i12] * width, fArr5[i13] * height, 2.6f * f5, paint);
                                i12 += 2;
                            }
                        }
                    }
                    float f36 = width * 0.02f;
                    paint.setShader(new RadialGradient(f35 - f36, f33 - f36, width * 0.11f, toColorInt(4294953376L), toColorInt(4293950012L), Shader.TileMode.CLAMP));
                    canvas.drawCircle(f35, f33, 0.085f * width, paint);
                    paint.setShader(null);
                    float[][] fArr6 = {new float[]{0.2f, 0.09f, 0.035f}, new float[]{0.84f, 0.1f, 0.055f}, new float[]{0.95f, 0.26f, 0.04f}, new float[]{0.06f, 0.27f, 0.03f}};
                    for (int i14 = 0; i14 < 4; i14++) {
                        float[] fArr7 = fArr6[i14];
                        float f37 = fArr7[0] * width;
                        float f38 = fArr7[2] * width;
                        float f39 = f38 * 0.3f;
                        paint.setShader(new RadialGradient(f37 - f39, (fArr7[1] * height) - f39, f38 * 1.4f, toColorInt(4294959308L), toColorInt(4293429610L), Shader.TileMode.CLAMP));
                        canvas.drawCircle(fArr7[0] * width, fArr7[1] * height, fArr7[2] * width, paint);
                        paint.setShader(null);
                    }
                    break;
                }
                canvas2 = canvas;
                canvas2.drawColor(theme.statusBarColor);
                break;
            case -1354599733:
                if (str.equals("cotton")) {
                    fillVerticalGradient(canvas, paint, width, height, new int[]{toColorInt(4294938545L), toColorInt(4288846846L), toColorInt(4278248959L)}, new float[]{0.0f, 0.5f, 1.0f});
                    drawGlowCircle(width * 0.2f, height * 0.2f, width * 0.5f, 1157627903, canvas, paint);
                    break;
                }
                canvas2 = canvas;
                canvas2.drawColor(theme.statusBarColor);
                break;
            case -897056407:
                if (str.equals("soccer")) {
                    fillVerticalGradient(canvas, paint, width, height, new int[]{toColorInt(4284264009L), toColorInt(4284725327L), toColorInt(4285383766L)}, new float[]{0.0f, 0.5f, 1.0f});
                    paint.setColor(352321535);
                    for (int i15 = 0; i15 < 8; i15++) {
                        float f40 = ((i15 * 0.14f) + 0.08f) * height;
                        Path path6 = new Path();
                        path6.moveTo(0.0f, f40);
                        path6.lineTo(width, f40 - (height * 0.2f));
                        path6.lineTo(width, f40 - (height * 0.13f));
                        path6.lineTo(0.0f, (height * 0.07f) + f40);
                        path6.close();
                        canvas.drawPath(path6, paint);
                    }
                    paint.setColor(856705554);
                    Path path7 = new Path();
                    path7.moveTo(width * 0.2f, height * 0.2f);
                    float f41 = height * 0.17f;
                    path7.lineTo(width * 0.62f, f41);
                    path7.lineTo(width * 0.78f, height * 0.27f);
                    path7.lineTo(width * 0.34f, 0.31f * height);
                    path7.close();
                    canvas.drawPath(path7, paint);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeCap(Paint.Cap.ROUND);
                    paint.setStrokeWidth(1.6f * f5);
                    paint.setColor(toColorInt(3439329279L));
                    float f42 = width * 0.7f;
                    float f43 = height * 0.52f;
                    canvas.drawLine(0.0f, f41, f42, f43, paint);
                    canvas.drawLine(f42, f43, width, height * 0.36f, paint);
                    float f44 = width * 0.42f;
                    float f45 = height * 0.76f;
                    canvas.drawLine(0.0f, height * 0.5f, f44, f45, paint);
                    canvas.drawLine(f44, f45, width * 0.9f, height * 0.55f, paint);
                    canvas.drawArc(new RectF((-width) * 0.2f, height * 0.6f, width * 0.25f, height * 0.78f), -60.0f, 100.0f, false, paint);
                    paint.setStrokeWidth(2.2f * f5);
                    paint.setColor(toColorInt(3154116607L));
                    float f46 = width * 0.28f;
                    float f47 = height * 0.045f;
                    canvas.drawLine(f46, f47, f46, f41, paint);
                    float f48 = height * 0.02f;
                    canvas.drawLine(f46, f47, f42, f48, paint);
                    canvas.drawLine(f42, f48, f42, height * 0.14f, paint);
                    paint.setStrokeWidth(f5 * 1.4f);
                    paint.setColor(toColorInt(2298478591L));
                    float f49 = height * 0.1f;
                    canvas.drawLine(f46, f47, f44, f49, paint);
                    float f50 = width * 0.82f;
                    float f51 = height * 0.09f;
                    canvas.drawLine(f42, f48, f50, f51, paint);
                    canvas.drawLine(f44, f49, f50, f51, paint);
                    float f52 = height * 0.22f;
                    canvas.drawLine(f46, f41, f44, f52, paint);
                    canvas.drawLine(f44, f49, f44, f52, paint);
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(856705554);
                    canvas.drawOval(new RectF(0.285f * width, 0.372f * height, 0.355f * width, 0.382f * height), paint);
                    paint.setColor(toColorInt(4294967295L));
                    float f53 = 0.32f * width;
                    float f54 = 0.362f * height;
                    canvas.drawCircle(f53, f54, width * 0.018f, paint);
                    paint.setColor(toColorInt(4280427042L));
                    canvas.drawCircle(f53, f54, 0.007f * width, paint);
                    break;
                }
                canvas2 = canvas;
                canvas2.drawColor(theme.statusBarColor);
                break;
            case -873907232:
                if (str.equals("tiedye")) {
                    fillVerticalGradient(canvas, paint, width, height, new int[]{toColorInt(4293588479L), toColorInt(4292931839L)}, null);
                    float f55 = (-width) * 0.02f;
                    float f56 = height * 0.5f;
                    float[] fArr8 = {width * 0.2f, width * 0.3f, width * 0.4f, 0.58f * width};
                    int i16 = 0;
                    int i17 = 0;
                    for (int i18 = 4; i16 < i18; i18 = 4) {
                        float f57 = fArr8[i16];
                        Path path8 = new Path();
                        int i19 = -95;
                        boolean z3 = z;
                        while (i19 <= 95) {
                            float[] fArr9 = fArr8;
                            double d4 = i19;
                            double radians2 = Math.toRadians(d4);
                            double d5 = i17;
                            int i20 = i16;
                            int i21 = i17;
                            double d6 = width;
                            double sin = ((float) ((Math.sin((d4 * 0.77d) + d5) * d6 * 0.006d) + (Math.sin((2.0d * d5) + (0.31d * d4)) * d6 * 0.012d))) + f57;
                            float cos = ((float) (Math.cos(radians2) * sin)) + f55;
                            float sin2 = ((float) (Math.sin(radians2) * sin * 1.5f)) + f56;
                            if (z3) {
                                path8.moveTo(cos, sin2);
                                z3 = false;
                            } else {
                                path8.lineTo(cos, sin2);
                            }
                            i19 += 3;
                            fArr8 = fArr9;
                            i16 = i20;
                            i17 = i21;
                        }
                        paint.setStyle(Paint.Style.STROKE);
                        paint.setStrokeCap(Paint.Cap.ROUND);
                        paint.setMaskFilter(new BlurMaskFilter(0.014f * width, BlurMaskFilter.Blur.NORMAL));
                        paint.setStrokeWidth(width * 0.03f);
                        paint.setColor(1430219752);
                        canvas.drawPath(path8, paint);
                        paint.setMaskFilter(null);
                        paint.setStrokeWidth(0.009f * width);
                        paint.setColor(toColorInt(3426708456L));
                        canvas.drawPath(path8, paint);
                        z = true;
                        i17++;
                        i16++;
                    }
                    paint.setStyle(Paint.Style.FILL);
                    break;
                }
                canvas2 = canvas;
                canvas2.drawColor(theme.statusBarColor);
                break;
            case -622659773:
                if (str.equals("avocado")) {
                    char c2 = 3;
                    int i22 = 8;
                    fillVerticalGradient(canvas, paint, width, height, new int[]{toColorInt(4293521588L), toColorInt(4293062056L)}, null);
                    float[][] fArr10 = {new float[]{0.12f, 0.43f, 0.19f, 18.0f}, new float[]{0.72f, 0.12f, 0.19f, 12.0f}, new float[]{0.5f, 0.3f, 0.2f, -14.0f}, new float[]{0.15f, 0.78f, 0.17f, 10.0f}, new float[]{0.8f, 0.58f, 0.2f, -8.0f}, new float[]{0.5f, 0.88f, 0.16f, 20.0f}, new float[]{0.2f, 0.08f, 0.14f, -20.0f}, new float[]{0.98f, 0.82f, 0.16f, 16.0f}};
                    int i23 = 0;
                    while (i23 < i22) {
                        float[] fArr11 = fArr10[i23];
                        float f58 = fArr11[0] * width;
                        float f59 = fArr11[1] * height;
                        float f60 = fArr11[2] * width;
                        canvas.save();
                        canvas.translate(f58, f59);
                        canvas.rotate(fArr11[c2]);
                        paint.setColor(toColorInt(4284390975L));
                        float f61 = -f60;
                        float f62 = f61 * 0.1f;
                        canvas.drawOval(new RectF(f61 * 0.62f, 1.3f * f61, f60 * 0.62f, f62), paint);
                        canvas.drawOval(new RectF(0.95f * f61, f61 * 0.55f, 0.95f * f60, f60 * 1.05f), paint);
                        paint.setColor(toColorInt(4290369164L));
                        float f63 = f61 * 0.5f;
                        canvas.drawOval(new RectF(f63, 1.18f * f61, f60 * 0.5f, f62), paint);
                        canvas.drawOval(new RectF(f61 * 0.8f, f63, f60 * 0.8f, f60 * 0.9f), paint);
                        paint.setColor(toColorInt(4287318597L));
                        canvas.drawCircle(0.0f, f60 * 0.28f, f60 * 0.34f, paint);
                        paint.setColor(1442840575);
                        canvas.drawCircle(f62, f60 * 0.18f, f60 * 0.1f, paint);
                        paint.setColor(toColorInt(4282276382L));
                        float f64 = f61 * 0.38f;
                        float f65 = f60 * 0.045f;
                        canvas.drawCircle(f61 * 0.2f, f64, f65, paint);
                        canvas.drawCircle(f60 * 0.2f, f64, f65, paint);
                        paint.setColor(1727371936);
                        float f66 = f61 * 0.36f;
                        float f67 = f61 * 0.28f;
                        float f68 = f60 * 0.07f;
                        canvas.drawCircle(f66, f67, f68, paint);
                        canvas.drawCircle(f60 * 0.36f, f67, f68, paint);
                        canvas.restore();
                        i23++;
                        i22 = 8;
                        c2 = 3;
                    }
                    break;
                }
                canvas2 = canvas;
                canvas2.drawColor(theme.statusBarColor);
                break;
            case 113953:
                if (str.equals("sky")) {
                    fillVerticalGradient(canvas, paint, width, height, new int[]{toColorInt(4286566655L), toColorInt(4288601599L), toColorInt(4291687679L)}, new float[]{0.0f, 0.55f, 1.0f});
                    float f69 = width * 0.07f;
                    drawCloud(width * 0.52f, height * 0.12f, f69, 150, canvas, paint);
                    float f70 = height * 0.2f;
                    float f71 = width * 0.05f;
                    drawCloud(f69, f70, f71, 150, canvas, paint);
                    drawCloud(width * 0.62f, 0.29f * height, width * 0.12f, 190, canvas, paint);
                    float f72 = width * 0.06f;
                    drawCloud(width * 0.2f, 0.38f * height, f72, 130, canvas, paint);
                    drawCloud(f72, height * 0.6f, width * 0.1f, 200, canvas, paint);
                    drawCloud(width * 0.55f, height * 0.55f, f71, 120, canvas, paint);
                    drawCloud(width * 0.7f, height * 0.8f, 0.11f * width, 210, canvas, paint);
                    paint.setColor(toColorInt(4280965754L));
                    canvas.drawCircle(0.77f * width, f70, f5 * 1.4f, paint);
                    break;
                }
                canvas2 = canvas;
                canvas2.drawColor(theme.statusBarColor);
                break;
            case 3046161:
                if (str.equals("care")) {
                    fillVerticalGradient(canvas, paint, width, height, new int[]{toColorInt(4292081648L), toColorInt(4289326040L), toColorInt(4288669412L), toColorInt(4291098338L)}, new float[]{0.0f, 0.42f, 0.72f, 1.0f});
                    float f73 = width * 0.5f;
                    drawGlowCircle(f73, height * 0.3f, width * 0.55f, toColorInt(3153133528L), canvas, paint);
                    paint.setStyle(Paint.Style.STROKE);
                    for (int i24 = 0; i24 < 5; i24++) {
                        float f74 = ((i24 * 0.1f) + 0.2f) * width;
                        paint.setStrokeWidth(width * 0.03f);
                        paint.setColor((toColorInt(4294967295L) & 16777215) | ((70 - (i24 * 12)) << 24));
                        float f75 = height * 0.36f;
                        canvas.drawArc(new RectF(f73 - f74, f75 - f74, f73 + f74, f75 + f74), 180.0f, 180.0f, false, paint);
                    }
                    paint.setStyle(Paint.Style.FILL);
                    break;
                }
                canvas2 = canvas;
                canvas2.drawColor(theme.statusBarColor);
                break;
            case 3357411:
                if (str.equals("mono")) {
                    canvas.drawColor(toColorInt(4293980400L));
                    break;
                }
                canvas2 = canvas;
                canvas2.drawColor(theme.statusBarColor);
                break;
            case 93627158:
                if (str.equals("berry")) {
                    fillVerticalGradient(canvas, paint, width, height, new int[]{toColorInt(4294266080L), toColorInt(4287504319L), toColorInt(4281998476L)}, new float[]{0.0f, 0.55f, 1.0f});
                    drawGlowCircle(width * 0.25f, height * 0.1f, width * 0.55f, 1157607664, canvas, paint);
                    break;
                }
                canvas2 = canvas;
                canvas2.drawColor(theme.statusBarColor);
                break;
            case 104263205:
                if (str.equals("music")) {
                    fillVerticalGradient(canvas, paint, width, height, new int[]{toColorInt(4294244095L), toColorInt(4294638335L)}, null);
                    float f76 = width * 0.62f;
                    float f77 = 0.37f * height;
                    int[] iArr3 = {toColorInt(4294162143L), toColorInt(4290362879L), toColorInt(4289128178L), toColorInt(4294956725L), toColorInt(4291999999L)};
                    paint.setStyle(Paint.Style.STROKE);
                    for (int i25 = 1; i25 < 46; i25++) {
                        float f78 = i25;
                        float f79 = 0.016f * width * f78;
                        float f80 = (f78 * 0.004f) + 0.52f;
                        int i26 = i25 % 5;
                        paint.setStrokeWidth(((i26 * 5.0E-4f) + 0.006f) * width);
                        int i27 = iArr3[i26] & 16777215;
                        int i28 = ((46 - i25) * 2) + 70;
                        if (i28 > 200) {
                            i28 = 200;
                        }
                        paint.setColor(i27 | (i28 << 24));
                        float f81 = f80 * f79;
                        canvas.drawOval(new RectF(f76 - f79, f77 - f81, f79 + f76, f81 + f77), paint);
                    }
                    paint.setStyle(Paint.Style.FILL);
                    drawGlowCircle(f76, f77, width * 0.14f, toColorInt(3439329279L), canvas, paint);
                    paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, height, new int[]{toColorInt(4294507007L), 16316927, 16316927, toColorInt(4294507007L)}, new float[]{0.0f, 0.18f, 0.7f, 1.0f}, Shader.TileMode.CLAMP));
                    canvas.drawRect(0.0f, 0.0f, width, height, paint);
                    paint.setShader(null);
                    break;
                }
                canvas2 = canvas;
                canvas2.drawColor(theme.statusBarColor);
                break;
            case 105560318:
                if (str.equals("ocean")) {
                    fillVerticalGradient(canvas, paint, width, height, new int[]{toColorInt(4288739312L), toColorInt(4284281072L), toColorInt(4278249717L)}, new float[]{0.0f, 0.45f, 1.0f});
                    paint.setColor(587202559);
                    for (int i29 = 0; i29 < 4; i29++) {
                        float f82 = ((i29 * 0.2f) + 0.15f) * width;
                        Path path9 = new Path();
                        path9.moveTo(f82, 0.0f);
                        path9.lineTo((width * 0.08f) + f82, 0.0f);
                        float f83 = height * 0.8f;
                        path9.lineTo((width * 0.3f) + f82, f83);
                        path9.lineTo((width * 0.05f) + f82, f83);
                        path9.close();
                        canvas.drawPath(path9, paint);
                    }
                    paint.setColor(1426109636);
                    Path path10 = new Path();
                    float f84 = height * 0.05f;
                    path10.moveTo(0.0f, f84);
                    path10.lineTo(width * 0.2f, height * 0.1f);
                    path10.lineTo(width * 0.13f, height * 0.3f);
                    path10.lineTo(width * 0.22f, height * 0.5f);
                    float f85 = width * 0.1f;
                    path10.lineTo(f85, height * 0.7f);
                    float f86 = height * 0.72f;
                    path10.lineTo(0.0f, f86);
                    path10.close();
                    canvas.drawPath(path10, paint);
                    Path path11 = new Path();
                    path11.moveTo(width, height * 0.08f);
                    path11.lineTo(width * 0.82f, height * 0.14f);
                    path11.lineTo(width * 0.9f, height * 0.34f);
                    path11.lineTo(width * 0.8f, height * 0.55f);
                    path11.lineTo(0.92f * width, 0.75f * height);
                    path11.lineTo(width, height * 0.78f);
                    path11.close();
                    canvas.drawPath(path11, paint);
                    paint.setColor(1711308943);
                    float f87 = 0.56f * width;
                    float f88 = height * 0.24f;
                    float f89 = 0.025f * height;
                    canvas.drawOval(new RectF(f87 - f85, f88 - f89, f85 + f87, f89 + f88), paint);
                    float f90 = width * 0.12f;
                    float f91 = width * 0.03f;
                    canvas.drawCircle(f87 + f90, f88 - (0.004f * height), f91, paint);
                    float f92 = f87 - (width * 0.04f);
                    float f93 = (width * 0.05f) + f87;
                    float f94 = 0.01f * height;
                    canvas.drawOval(new RectF(f92, f88 - f84, f93, f88 - f94), paint);
                    canvas.drawOval(new RectF(f92, f94 + f88, f93, f84 + f88), paint);
                    float f95 = 0.012f * height;
                    canvas.drawOval(new RectF(f87 - f90, f88 - f95, f87 - (width * 0.07f), f88 + f95), paint);
                    paint.setColor(1426096271);
                    canvas.drawOval(new RectF(width * 0.7f, 0.38f * height, width * 0.78f, 0.405f * height), paint);
                    canvas.drawOval(new RectF(width * 0.35f, height * 0.45f, 0.41f * width, 0.465f * height), paint);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeCap(Paint.Cap.ROUND);
                    paint.setStrokeWidth(width * 0.018f);
                    paint.setColor(1426104496);
                    for (int i30 = 0; i30 < 5; i30++) {
                        float f96 = i30;
                        float f97 = ((f96 * 0.04f) + 0.15f) * width;
                        Path path12 = new Path();
                        path12.moveTo(f97, f86);
                        path12.cubicTo(f97 - f91, height * 0.65f, f97 + f91, height * 0.6f, f97, ((f96 * 0.015f) + 0.52f) * height);
                        canvas.drawPath(path12, paint);
                    }
                    paint.setStrokeWidth(1.2f * f5);
                    paint.setColor(1728053247);
                    Random random3 = new Random(11L);
                    for (int i31 = 0; i31 < 14; i31++) {
                        canvas.drawCircle(random3.nextFloat() * width, random3.nextFloat() * height, ((random3.nextFloat() * 5.0f) + 2.0f) * f5, paint);
                    }
                    paint.setStyle(Paint.Style.FILL);
                    break;
                }
                canvas2 = canvas;
                canvas2.drawColor(theme.statusBarColor);
                break;
            case 106683528:
                if (str.equals("pizza")) {
                    fillVerticalGradient(canvas, paint, width, height, new int[]{toColorInt(4294942784L), toColorInt(4294941240L), toColorInt(4294939440L)}, new float[]{0.0f, 0.5f, 1.0f});
                    float f98 = width * 0.5f;
                    float f99 = height * 0.27f;
                    float f100 = width * 0.2f;
                    canvas.save();
                    canvas.translate((width * 0.02f) + f98, (height * 0.02f) + f99);
                    canvas.rotate(38.0f);
                    paint.setColor(1724473615);
                    Path path13 = new Path();
                    float f101 = -f100;
                    float f102 = -f98;
                    float f103 = f102 * 0.5f;
                    path13.moveTo(f101, f103);
                    path13.lineTo(f100, f103);
                    float f104 = f98 * 0.55f;
                    path13.lineTo(0.0f, f104);
                    path13.close();
                    canvas.drawPath(path13, paint);
                    canvas.restore();
                    canvas.save();
                    canvas.translate(f98, f99);
                    canvas.rotate(38.0f);
                    paint.setColor(toColorInt(4293943850L));
                    Path path14 = new Path();
                    path14.moveTo(f101, f103);
                    path14.lineTo(f100, f103);
                    path14.lineTo(0.0f, f104);
                    path14.close();
                    canvas.drawPath(path14, paint);
                    paint.setColor(toColorInt(4294962120L));
                    canvas.drawCircle(f101 * 0.45f, f102 * 0.2f, f100 * 0.28f, paint);
                    canvas.drawCircle(f100 * 0.5f, f102 * 0.12f, 0.24f * f100, paint);
                    float f105 = f100 * 0.2f;
                    canvas.drawCircle(0.0f, f98 * 0.22f, f105, paint);
                    canvas.drawCircle(f101 * 0.1f, f102 * 0.42f, f100 * 0.18f, paint);
                    paint.setColor(toColorInt(4292231210L));
                    float f106 = f100 * 0.1f;
                    canvas.drawCircle(f106, f102 * 0.3f, f105, paint);
                    canvas.drawCircle(f101 * 0.18f, f98 * 0.02f, 0.17f * f100, paint);
                    paint.setColor(toColorInt(4283215696L));
                    canvas.drawCircle(f100 * 0.05f, f102 * 0.04f, f106, paint);
                    paint.setColor(toColorInt(4282062080L));
                    float f107 = f102 * 0.06f;
                    float f108 = 0.045f * f100;
                    canvas.drawCircle(f101 * 0.3f, f107, f108, paint);
                    canvas.drawCircle(f100 * 0.3f, f107, f108, paint);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(1.6f * f5);
                    paint.setStrokeCap(Paint.Cap.ROUND);
                    canvas.drawArc(new RectF(f101 * 0.2f, f102 * 0.08f, f105, f98 * 0.0f), 20.0f, 140.0f, false, paint);
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(toColorInt(4293435480L));
                    float f109 = f101 * 1.08f;
                    float f110 = f102 * 0.62f;
                    float f111 = f100 * 1.08f;
                    float f112 = f102 * 0.44f;
                    canvas.drawRoundRect(new RectF(f109, f110, f111, f112), f105, f105, paint);
                    paint.setColor(toColorInt(4291394612L));
                    canvas.drawRoundRect(new RectF(f109, f103, f111, f112), f106, f106, paint);
                    canvas.restore();
                    break;
                }
                canvas2 = canvas;
                canvas2.drawColor(theme.statusBarColor);
                break;
            case 1544803905:
                if (str.equals("default")) {
                    fillVerticalGradient(canvas, paint, width, height, new int[]{toColorInt(4288348415L), toColorInt(4285150719L), toColorInt(4278223103L)}, new float[]{0.0f, 0.45f, 1.0f});
                    break;
                }
                canvas2 = canvas;
                canvas2.drawColor(theme.statusBarColor);
                break;
            default:
                canvas2 = canvas;
                canvas2.drawColor(theme.statusBarColor);
                break;
        }
    }

    public static final void drawCloud(float x, float y, float size, int alpha, Canvas canvas, Paint paint) {
        paint.setColor((alpha << 24) | (((int) 4294967295L) & 16777215));
        float f5 = 0.5f * size;
        canvas.drawCircle(x, y, f5, paint);
        float f6 = 0.55f * size;
        canvas.drawCircle(x + f6, y - (0.22f * size), 0.7f * size, paint);
        canvas.drawCircle((1.2f * size) + x, y, f6, paint);
        canvas.drawCircle((1.75f * size) + x, (0.05f * size) + y, 0.4f * size, paint);
        RectF rectF = new RectF(x - f5, y, (2.15f * size) + x, f5 + y);
        float f7 = size * 0.25f;
        canvas.drawRoundRect(rectF, f7, f7, paint);
    }

    public static void drawGlowCircle(float x, float y, float radius, int color, Canvas canvas, Paint paint) {
        paint.setShader(new RadialGradient(x, y, radius, color, color & 16777215, Shader.TileMode.CLAMP));
        canvas.drawCircle(x, y, radius, paint);
        paint.setShader(null);
    }

    public static void fillVerticalGradient(Canvas canvas, Paint paint, float width, float height, int[] colors, float[] positions) {
        paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, height, colors, positions, Shader.TileMode.CLAMP));
        canvas.drawRect(0.0f, 0.0f, width, height, paint);
        paint.setShader(null);
    }
}
