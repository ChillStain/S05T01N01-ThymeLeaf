package cat.itacademy.barcelonactiva.gasull.carlos.s05.t01.n01.controllers;


import cat.itacademy.barcelonactiva.gasull.carlos.s05.t01.n01.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.gasull.carlos.s05.t01.n01.model.Sucursal;
import cat.itacademy.barcelonactiva.gasull.carlos.s05.t01.n01.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller

public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    //Llamar a vistas de ThyMeLeaf

    @GetMapping({"/sucursales","/"})
    public String listSucursals(Model modelo){
        modelo.addAttribute("sucursales",sucursalService.listAllSucursal());
        return "sucursales";//return sucursales archive
    }



    @PostMapping("/agregar")
    public String agregarSucursal(@RequestBody SucursalDTO sucursalDto){

    return "add_sucursal";
    }

    @GetMapping("/sucursal/{id}")
    public String getSucursal (@PathVariable Long id) throws Exception {

        return "edit_sucursal";

    }

    /*@GetMapping("/todasSucursales")
    public List<Sucursal> getAllSucursal (){
        return sucursalService.getAllSucursal();
    }*/

    @PutMapping ("/actualizar/{id}")
    public String actualizarSucursal(@PathVariable Long id,@RequestBody SucursalDTO sucursalDto) throws Exception {

        if(!sucursalService.findById(id)){
            return  "No se encuentra la sucursal con id: "+id;
        }else {
            Sucursal sucursalNew = sucursalService.getSucursal(id);
            if (sucursalDto.getNombreSucursal() != null) {
                sucursalNew.setNombreSucursal(sucursalDto.getNombreSucursal());
            }
            if (sucursalDto.getPaisSucursal() != null) {
                sucursalNew.setPaisSucursal(sucursalDto.getPaisSucursal());
                sucursalNew.setTipoSucursal(sucursalDto.verificacionUE(sucursalDto.getPaisSucursal()));
            }
            sucursalService.actualizarSucursal(sucursalNew);
        }
        return "redirect:/sucursales";
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteSucursal (@PathVariable Long id){
        if(!sucursalService.findById(id)){
            return "No se encuentra la sucursal con id: "+id;
        }else{
            sucursalService.eliminarSucursal(id);
        }
        return "redirect:/sucursales";
    }



}
