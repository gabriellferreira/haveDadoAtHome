package br.com.havedadoathome.buildconfig.productflavor

class DevelopmentEnvironmentProductFlavor extends ProductFlavorConfig {

    @Override
    Boolean isFabricEnable() {
        return false
    }

    @Override
    String isOkHttpLogEnabled() {
        return true.toString()
    }

    @Override
    String isEventLogEnabled() {
        return true.toString()
    }
}