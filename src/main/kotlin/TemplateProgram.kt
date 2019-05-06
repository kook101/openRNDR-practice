import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.color.mix
import org.openrndr.draw.FontImageMap
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint

fun main() = application {
    configure {
        width = 1200
        height = 600
    }

    program {
        val image = loadImage("file:data/images/pm5544.png")
        val font = FontImageMap.fromUrl("file:data/fonts/IBMPlexMono-Regular.ttf", 64.0)

        extend {
            drawer.drawStyle.colorMatrix = tint(ColorRGBa.WHITE.shade(0.2))
            drawer.image(image)

            drawer.fill = ColorRGBa.PINK
            drawer.circle(Math.cos(seconds)*width/2.0+width/2.0, Math.sin(0.5*seconds)*height/2.0 + height/2.0, 140.0)


            val redCol = ColorRGBa.RED
            val greenCol = ColorRGBa.GREEN

            drawer.fill = mix(redCol, greenCol, (Math.cos(seconds) + 1) / 2.0);
            drawer.rectangle(width / 2.0, height / 2.0, 50.0, 100.0);


            drawer.fontMap = font
            drawer.fill = ColorRGBa.WHITE
            drawer.text("" + seconds, width/2.0, height /2.0)
        }
    }
}