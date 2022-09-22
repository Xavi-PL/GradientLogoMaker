import javax.imageio.*;
import java.awt.image.*;
import java.awt.*;
import java.io.*;

class GradientLogoMaker {
    public static BufferedImage drawImage(int size, Color startColor, Color endColor, String text, boolean darkTheme) {
        GradientPaint gp = new GradientPaint(0, 0, startColor, size, size, endColor);
        BufferedImage bim = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        // Draw the gradient
        Graphics2D g2 = bim.createGraphics();
        g2.setPaint(gp);
        g2.setRenderingHints(qualityHints);
        g2.fillRoundRect(0, 0, size, size, 0, 0);

        // Draw the text
        g2.setColor(darkTheme ? Color.WHITE : Color.BLACK);
        g2.setFont(new Font("Roboto", Font.PLAIN, 200));
        FontMetrics metrics = g2.getFontMetrics();
        int x = size / 2 - (metrics.stringWidth(text) / 2);
        int y = size / 2 + (metrics.getAscent() / 3);
        g2.drawString(text, x, y);

        g2.dispose();
        return bim;
    }

    public static void main(String args[]) {
        try {
            int idUser = 125;
            BufferedImage gradientLogo = GradientLogoMaker.drawImage(512, Color.decode("#F1A10C"), Color.decode("#FFFB00"), "NP", true);
            ImageIO.write(gradientLogo, "PNG", new File(idUser + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}