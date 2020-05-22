package mx.edu.ittepic.ladm_u4_practica2_campos_aguirre

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View


class Lienzo (p:MainActivity) : View(p){

    override fun onDrawForeground(c: Canvas  ) {
        super.onDrawForeground(c)

        var p = Paint()
        var pa = Path()

        //CESPED
        p.color= Color.rgb(89,216,61)
        c.drawRect(0f,1000f,1100f,1700f,p)

        //TECHO
        pa.moveTo(290f,600f)
        pa.lineTo(850f,610f)
        pa.lineTo(580f,445f)
        p.color=(Color.parseColor("#5B3924"))
        c.drawPath(pa,p)

        //DECORACION
        p.color=(Color.parseColor("#FFEDBE"))
        c.drawRect(320f,600f,820f,1000f,p)

        //PUERTA
        p.color=(Color.parseColor("#5B3924"))
        c.drawRect(510f,850f,620f,1000f,p)

        //VENTANA
        p.color=(Color.parseColor("#5B3924"))
        c.drawCircle(390f,750f,35f,p)

        //ARBOLES
        p.color= Color.rgb(57, 148,15)
        c.drawCircle(190f,750f,35f,p)
        p.color= Color.rgb(57, 148,15)
        c.drawCircle(150f,750f,35f,p)
        p.color= Color.rgb(57, 148,15)
        c.drawCircle(190f,805f,35f,p)
        p.color= Color.rgb(57, 148,15)
        c.drawCircle(150f,805f,35f,p)

        //TRONCO
        p.color= Color.rgb(110,78,11)
        c.drawRect(155f,830f,180f,1000f,p)
    }

    //IMAGENES
    var arcoiris = Imagen(this, 578f, 100f, R.drawable.arcoiris)
    var avion = Imagen(this, 1778f, 100f, R.drawable.avion)
    var nube = Imagen(this, 2978f, 100f, R.drawable.nube)
    var pajaro = Imagen(this, 4178f, 100f, R.drawable.pajaro)
    var sol = Imagen(this, 5378f, 100f, R.drawable.sol)
    var cometa = Imagen(this, 6578f, 100f, R.drawable.cometa)
    var estrellas = Imagen(this, 7778f, 100f, R.drawable.estrellas)
    var globo = Imagen(this, 8978f, 100f, R.drawable.globoaerostatico)

    //Arreglo categorizando las imagenes
    var cielo = arrayListOf<Imagen>(arcoiris,avion,nube,pajaro,sol,cometa,estrellas,globo)
    val puntero = p


    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        if (puntero.distancia == 0f){
            arcoiris.invisible == false
            avion.invisible == false
            cometa.invisible == false
            estrellas.invisible == false
            globo.invisible == false
            nube.invisible == false
            pajaro.invisible == false
            sol.invisible == false
            invalidate()
        }else{
            when (puntero.contShake){
                0 -> {
                    dibujarImgs(cielo,c)
                    moverImgs(cielo,puntero.x)
                }
            }
        }
    }

    fun moverImgs(arrayImagenes: ArrayList<Imagen>,x:Float){
        arrayImagenes.forEach {
            it.mover(x)
        }
        invalidate()
    }
    fun dibujarImgs(arrayImagenes: ArrayList<Imagen>,c: Canvas) {
        arrayImagenes.forEach {
            it.pintar(c)

        }
    }
}