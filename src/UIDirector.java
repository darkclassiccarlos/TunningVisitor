public class UIDirector {
    private Order builder;
    public UIDirector(Order bldr) {
        builder = bldr;
    }
    public void build() {
        builder.addUIControls();
        builder.initialize();
    }
}
