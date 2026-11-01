package a;

import com.nix.host.MainActivity;

public final class DelegateAction implements h.a {

    public final int mode;

    public final h.a delegate;

    public DelegateAction(h.a aVar, int i2) {
        this.mode = i2;
        this.delegate = aVar;
    }

    @Override
    public final Object a() {
        h.a aVar = this.delegate;
        switch (this.mode) {
            case 0:
                aVar.a();
                break;
            default:
                int i2 = MainActivity.R;
                aVar.a();
                break;
        }
        return b.d.f770c;
    }
}
