import javax.swing.*;

public abstract class UIBuilder {
    protected JPanel searchUI;

    public abstract void addUIControls();
    public abstract void initialize();
    public abstract String getOrderAmountText();
    public abstract String getTaxtext();
    public abstract String getSHtext();
    //public abstract double getAdditionalSH();
    public JPanel getSearchUI() {
        return searchUI;
    }
}
