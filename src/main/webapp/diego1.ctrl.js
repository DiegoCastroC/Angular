'use strict'
angular.module('ligaBaloncestoApp')
    .controller('diego1Ctrl',function ($scope, $http, Jugador) {

        $http.get("api/equipos").then(function (response) {
            $scope.equipos = response.data;
        });

        $scope.canastas = function () {
            if($scope.equipoSelect == null) {
                Jugador.can({can: $scope.canastasTotales}, function (response) {
                    $scope.jugadores = response;
                })
            }else{
                //codigo equipo y canastas
                Jugador.dobleparam({canastasTotales: $scope.canastasTotales, equiposelec: $scope.equipoSelect}, function (response){
                    $scope.jugadores = response;
                })
            }
        };

        $scope.equipofunc = function() {
            $scope.canastas();
        };

        $scope.filtrarPor = function (filtro) {
            $scope.filtracion = filtro;
        };
    });

