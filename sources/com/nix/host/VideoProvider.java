package com.nix.host;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import i.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class VideoProvider extends ContentProvider {
    public final File a(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            lastPathSegment = "";
        }
        Pattern compile = Pattern.compile("^v_[A-Za-z0-9-]+$");
        b.d(compile, "compile(...)");
        if (!compile.matcher(lastPathSegment).matches()) {
            throw new FileNotFoundException();
        }
        Context context = getContext();
        b.b(context);
        File file = new File(new File(context.getCacheDir(), "chat"), lastPathSegment);
        if (file.exists()) {
            return file;
        }
        throw new FileNotFoundException();
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return "video/mp4";
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri, String str) {
        return ParcelFileDescriptor.open(a(uri), 268435456);
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        long j2;
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"_display_name", "_size"});
        try {
            j2 = a(uri).length();
        } catch (Exception unused) {
            j2 = 0;
        }
        matrixCursor.addRow(new Object[]{"NixHost_video.mp4", Long.valueOf(j2)});
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
