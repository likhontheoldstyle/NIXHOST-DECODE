package a;

import com.nix.host.MainActivity;

public final class RefAction implements h.a {

    public final int mode;

    public final Object target;

    public RefAction(int i2, Object obj) {
        this.mode = i2;
        this.target = obj;
    }

    @Override
    public final Object a() {
        switch (this.mode) {
            case 0:
                ((E2) this.target).dismiss();
                return b.d.f770c;
            case 1:
                int i2 = MainActivity.R;
                ((h.a) ((i.g) this.target).f850b).a();
                return b.d.f770c;
            default:
                return Boolean.valueOf(((TerminalSession) this.target).installCancelled);
        }
    }
}
