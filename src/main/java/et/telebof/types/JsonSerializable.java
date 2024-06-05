package et.telebof.types;

abstract public class JsonSerializable {

    @Override
    public final String toString() {
        StringBuilder str = new StringBuilder(this.getClass().getSimpleName() + "={");
        int count = 0;
        for (Object ob : getClass().getDeclaredFields()) {
            int len = ob.toString().split(" ")[2].split("\\.").length;
            String type = ob.toString().split(" ")[1];
            String obj = ob.toString().split(" ")[2].split("\\.")[len-1];{
                count++;

                String cm = count == this.getClass().getDeclaredFields().length ? "}" : ", ";
                try {
                    Object ftr = (this.getClass().getDeclaredField(obj).get(this));
                    if (type.equals("java.lang.String") && ftr != null)
                        ftr = String.format("%s", ftr);
                    str.append(String.format("%s", obj + ": " + ftr + cm));
                } catch (Exception ignored) {}

            }
        } return str.toString().equals("{")?"{}": str.toString();
    }

}
