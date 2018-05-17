package br.com.havedadoathome.presentation.util.connection

interface InternetConnectionVerifier {

    fun isConnectedToInternet(): Boolean

    fun getInternetConnectionType(): InternetConnectionType

    enum class InternetConnectionType {
        MOBILE_DATA,
        WIFI,
        NO_CONNECTION
    }
}