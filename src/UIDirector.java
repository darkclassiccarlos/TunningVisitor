public class UIDirector {
    private UIBuilder builder;
    public UIDirector(UIBuilder bldr) {
        builder = bldr;
    }
    public void build() {
        builder.addUIControls();
        builder.initialize();
        builder.getOrderAmountText();
        builder.getTaxtext();
        builder.getSHtext();
    }
}
