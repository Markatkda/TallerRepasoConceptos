package controller;

import application.Aplicacion;
import model.Empresa;

public class Singleton{

        Empresa empresa;
        private Aplicacion aplicacion;

        private static class SingletonHolder {

            private final static Singleton eINSTANCE = new Singleton();
        }

        public static Singleton getInstance() {

            return SingletonHolder.eINSTANCE;
        }

        public Singleton() {

            inicializarDatos();
        }


        private void inicializarDatos() {

            empresa = new Empresa();

        }


        public void setAplicacion(Aplicacion aplicacion) {
            this.aplicacion = aplicacion;

        }
        
        public Aplicacion getAplicacion(){
        	return aplicacion;
        }


        public void mostrarVentanaPrincipal(String ruta){
            aplicacion.mostrarVentanaPrincipal(ruta);
        }

        public void mostrarPanelNatural(String ruta) {
            aplicacion.mostrarPanelNatural(ruta);
        }
        
        public void mostrarPanelJuridico(String ruta) {
            aplicacion.mostrarPanelJuridico(ruta);
        }

        public void mostrarPanelPerecedero(String ruta) {
            aplicacion.mostrarPanelPerecedero(ruta);
        }

        public void mostrarPanelEnvasado(String ruta) {
            aplicacion.mostrarPanelEnvasado(ruta);
        }
        
        public void mostrarPanelRefrigerado(String ruta) {
            aplicacion.mostrarPanelRefrigerado(ruta);
        }
    }
