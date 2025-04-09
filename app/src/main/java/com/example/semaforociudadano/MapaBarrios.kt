package com.example.semaforociudadano

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolygonOptions

class MapaBarrios : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa_barrios)
        mapView = findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
    }
    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onMapReady(map: GoogleMap) {



        googleMap = map

        // Punto de interés
        val location = LatLng(-34.12983794856316, -63.3878545453066)

        // Configurar la cámara y moverla al punto de interés
        val cameraPosition = CameraPosition.Builder()
            .target(location)
            .zoom(12f)
            .build()
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))

        val polygonPoints = listOf(
            LatLng(-34.11579553332912, -63.394197513193085),
            LatLng(-34.11657718662176, -63.39048533605714),
            LatLng( -34.111345301377085, -63.38888673954484),
            LatLng(-34.11056359973317,  -63.39260964551643),

        )
        val polygonPoints02 = listOf(
            LatLng(-34.13185220962264, -63.371710296433406),
            LatLng(-34.13080665578604, -63.37719658374194),
            LatLng(-34.125588816388735, -63.37567966546458),
            LatLng(-34.12552664631275, -63.37562602128632),

        )

        val polygonPoints03 = listOf(
            LatLng(-34.12655688738804, -63.381344490689386),
            LatLng(-34.1275871159087, -63.37652724348117),
            LatLng(-34.12764040324931, -63.37625902258984),
            LatLng(-34.12452303733153, -63.38051837034409),
            LatLng(-34.12452303733153, -63.38051837034409)
        )

        val polygonPoints04 = listOf(
            LatLng(-34.12378586559013, -63.384434395562344),
            LatLng(-34.124745075709534, -63.384766989467586),
            LatLng(-34.12552664627923, -63.38104408349599),
            LatLng(-34.1254818289723, -63.3809878758315)
        )

        val polygonPoints05 = listOf(
            LatLng(-34.12481032737825, -63.38480530034219),
            LatLng(-34.13221394375613, -63.38707386064355),
            LatLng(-34.13329066156351, -63.38066807014989),
            LatLng(-34.13133021228814, -63.38002994542639),
            LatLng(-34.13184826289, -63.37752653304956),
            LatLng(-34.12762254779621, -63.376396738603866),
            LatLng(-34.12658040460685, -63.381339620596144),
            LatLng(-34.12552970625508, -63.38110227970716)
        )

        val polygonPoints06 = listOf(
            LatLng(-34.133931989248474, -63.378241952010974),
            LatLng(-34.13920748936996, -63.38510818572739),
            LatLng(-34.13957313839438, -63.37990501490496),
            LatLng(-34.13409839445155, -63.378125628656726)
        )

        val polygonPoints07 = listOf(
            LatLng(-34.13953020945197, -63.39263875242458),
            LatLng(-34.139632230174335, -63.38923546080234),
            LatLng(-34.14320191120883, -63.38880057049321),
            LatLng(-34.14325626279213, -63.38801616939122),
            LatLng(-34.14509211798664, -63.38811102721631)
        )

        val polygonPoints08 = listOf(
            LatLng(-34.13958917093443, -63.39666116994601),
            LatLng(-34.139497758843994, -63.39642800898935),
            LatLng(-34.14108222107959, -63.396231662920584),
            LatLng(-34.14071722785751, -63.393615656575214)
        )

        val polygonPoints09 = listOf(
            LatLng(-34.14217108601293, -63.40193401713719),
            LatLng(-34.14096684799387, -63.39877635139681),
            LatLng(-34.13947220246888, -63.39837390380245),
            LatLng(-34.139634479548135, -63.396660921734146),
            LatLng(-34.141086418493735, -63.396815709270435),
            LatLng(-34.141188907358945, -63.39361676685373),
            LatLng(-34.144076301556424, -63.40111652576903)
        )

        val polygonPoints10 = listOf(
            LatLng(-34.12034444518573, -63.40194546047536),
            LatLng(-34.1218632513611, -63.39343749365209),
            LatLng(-34.12705416001075, -63.39487852580353),
            LatLng(-34.12572278638865, -63.40182769801294)
        )

        val polygonPoints11 = listOf(
            LatLng(-34.1259581145281, -63.401795516849894),
            LatLng(-34.1262741732673, -63.39903611882073),
            LatLng(-34.12817050088922, -63.39658910547413),
            LatLng(-34.13009551730705, -63.39684942609749),
            LatLng(-34.131319716612275, -63.39478837274079),
            LatLng(-34.1394611312159, -63.400144190532416)
        )

        val polygonPoints12 = listOf(
            LatLng(-34.121619370571715, -63.394471831462035),
            LatLng(-34.12342960206689, -63.385829188578256),
            LatLng(-34.124090470635004, -63.384579649867135),
            LatLng(-34.13100054715189, -63.392423976349185),
            LatLng(-34.12960708446823, -63.395651951402165)
        )

        val polygonPoints13 = listOf(
            LatLng(-34.13033646472891, -63.39562214978507),
            LatLng(-34.13783274043475, -63.395450346929806),
            LatLng(-34.13951880297119, -63.395020839904355),
            LatLng(-34.13638026197031, -63.39093438736527)
        )

        val polygonPoints14 = listOf(
            LatLng(-34.1328657703018, -63.38341187849756),
            LatLng(-34.131839836216976, -63.38958450806014),
            LatLng(-34.13956958746115, -63.385915290943245),
            LatLng(-34.13304860876967, -63.383276890644126)
        )

        val polygonPoints15 = listOf(
            LatLng(-34.139497758843994, -63.40199932869072),
            LatLng(-34.141061907649195, -63.401753896104765),
            LatLng(-34.14062516771461, -63.398759618556014),
            LatLng(-34.139497758843994, -63.39926275535723)
        )

        val polygonPoints16 = listOf(
            LatLng(-34.1333038549803, -63.38063528740327),
            LatLng(-34.13134694549898, -63.3800515470483),
            LatLng(-34.131926775253866, -63.377556057030844),
            LatLng(-34.13393198915875, -63.3782565454568)
        )

        val polygonOptions1 = PolygonOptions()
        polygonOptions1.addAll(polygonPoints)
        polygonOptions1.strokeColor(Color.RED)
        polygonOptions1.strokeWidth(2f)
        polygonOptions1.fillColor(Color.argb(100, 255, 0, 0))

        googleMap.addPolygon(polygonOptions1)
        // Configura el mapa y agrega marcadores, etc.

        val polygonOptions2 = PolygonOptions()
        polygonOptions2.addAll(polygonPoints02)
        polygonOptions2.strokeColor(Color.RED)
        polygonOptions2.strokeWidth(2f)
        polygonOptions2.fillColor(Color.argb(100, 0, 255, 0))

        googleMap.addPolygon(polygonOptions2)
        // Configura el mapa y agrega marcadores, etc.

        val polygonOptions3 = PolygonOptions()
        polygonOptions3.addAll(polygonPoints03)
        polygonOptions3.strokeColor(Color.RED)
        polygonOptions3.strokeWidth(2f)
        polygonOptions3.fillColor(Color.argb(100, 0, 0, 255))

        googleMap.addPolygon(polygonOptions3)
        // Configura el mapa y agrega marcadores, etc.
    }




}