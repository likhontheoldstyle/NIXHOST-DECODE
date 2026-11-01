package a;

import java.io.File;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class N0 implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f219a;

    public /* synthetic */ N0(int i2) {
        this.f219a = i2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f219a) {
        }
        return AbstractC0008c.d(((File) obj).getName(), ((File) obj2).getName());
    }
}
