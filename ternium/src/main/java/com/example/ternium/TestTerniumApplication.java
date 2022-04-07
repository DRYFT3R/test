package com.example.ternium;

import com.example.ternium.dto.AtributoKpiInVo;
import com.example.ternium.dto.EjKpiInvo;
import com.example.ternium.dto.GpsPatenteOutVO2;
import com.example.ternium.dto.GpsPatenteOutVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;
import org.json.JSONObject;
import org.json.XML;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class TestTerniumApplication {

    String parametr;

    public static void main(String[] args) throws JsonProcessingException {
        //execute();
        executarGps();
        SpringApplication.run(TestTerniumApplication.class, args);
        //System.out.println("ejecuta test");

    }



    public static void executarGps() {
        String response = "[{\"latitud\":null,\"longitud\":null,\"ultimoReporte\":null,\"placa\":\"278DJ7\"},{\"latitud\":null,\"longitud\":null,\"ultimoReporte\":null,\"placa\":\"278DJ7\"},{\"latitud\":32.55793,\"longitud\":-115.300697,\"ultimoReporte\":\"2022-04-05 06:23:47.0\",\"placa\":\"278DJ7\"}]";
        ///ahoras klasjdlkjsalkajsdñ fkjasñdklfj ñaskldjf
        GpsPatenteOutVo out = new GpsPatenteOutVo();
        GpsPatenteOutVo.GpsLogitudVo[] out2 = null;
        ObjectMapper mapper = new ObjectMapper();
        try{
            out2 = mapper.readValue(response, GpsPatenteOutVo.GpsLogitudVo[].class);
        }catch (Exception e){
            System.out.println(e);
        }

        GpsPatenteOutVo gps = new GpsPatenteOutVo();
        gps.setUbicacion(Arrays.asList(out2));

        System.out.println(gps);


    }













    String out = "select \n" +
            "  C_ID AS ID ,--ID\n" +
            "  C_ID_EMPRESA_TRANSPORTE AS TRANSPORTE --TRANSPORTE \n" +
            "  from apt_permiso_circulacion WHERE C_ESTADO IN ('ING') AND C_ID_TIPO_PERMISO = '3'";

    static String kpi = "select * from apt_permiso_circulacion where c_id permiso = ? " +
            "and c_estado in (?) AND PLANTA = ? and dispositivo_id  = ?";

    static String parametros = "{" +
            "    \"entidad\": \"acumulado\"," +
            "    \"parametros\":" +
            "        [" +
            "            {" +
            "                \"permiso\":\"1\"" +
            "            }," +
            "            {" +
            "                \"estados\" : " +
            "                    [4,5,6]" +
            "            }," +
            "            {" +
            "                \"planta\":\"chu\"" +
            "            }," +

            "            {" +
            "                \"dispositivo\":\"psqsaqwe1\"" +
            "            }" +

            "        ]" +
            "}";

    static EjKpiInvo vo = new EjKpiInvo();

    static String xml ="<viajes><nro_viaje>437948</nro_viaje><f_fecha>2021-03-18</f_fecha><c_id_empresa_transportista>80099</c_id_empresa_transportista><n_empresa_transporte>SUBPRODUCTO RETIRA</n_empresa_transporte><c_estado>EXE</c_estado><q_cantidad>9.132</q_cantidad><m_envia_retira>E</m_envia_retira><f_fecha_alta>2021-03-18</f_fecha_alta><m_activa>S</m_activa><m_critico></m_critico></viajes><viajes><nro_viaje>437948</nro_viaje><f_fecha>2021-03-18</f_fecha><c_id_empresa_transportista>80099</c_id_empresa_transportista><n_empresa_transporte>SUBPRODUCTO RETIRA</n_empresa_transporte><c_estado>EXE</c_estado><q_cantidad>9.132</q_cantidad><m_envia_retira>E</m_envia_retira><f_fecha_alta>2021-03-18</f_fecha_alta><m_activa>S</m_activa><m_critico></m_critico></viajes>";


    private String ejecutarQuery(Object kpi, Map<String, Object> parametros){
        //StringBuilder sql = new StringBuilder(kpi.getSql());

        //procesarParametro(parametros,sql);
       // kpiDao.ejecutarKpi(generarKpiVo(sql.toString(),kpi));
        List<Object> out = null; //kpiDao.ejecutarQuery(sql.toString());
         String json = new Gson().toJson(out);
         return null;
    }

    static String sql = "lect \n" +
            "C_ID AS ID ,--Asd \n" +
            "C_ID_EMPRESA_TRANSPORTE AS TRANSPORTE --reasdas\n" +
            "C_ID_EMPRESA_TRANSPORTE AS TRANSPORTE --asdasdSASDASD\n" +
            "\n" +
            "from apt_permiso_circulacion WHERE C_ESTADO IN (?) AND C_ID_TIPO_PERMISO = ?";


    String sqlas = " \n" +
            " WITH TIPOS_PER AS (\n" +
            "    SELECT PROP.C_ID_TIPO, tipos.D_DESCRIPCION, 'GUE' C_PLANTA  \n" +
            "    FROM (\n" +
            "        select ( regexp_substr(\n" +
            "            ( '1,2,3,4,5,6,7,8,13,14,20,25' ),'[^,]+', 1, level)) C_ID_TIPO\n" +
            "            from \n" +
            "            dual\n" +
            "          connect by regexp_substr(\n" +
            "            ( '1,2,3,4,5,6,7,8,13,14,20,25' ), '[^,]+', 1, level) is not null\n" +
            "    ) PROP inner join apt_tipo_permiso tipos  ON tipos.C_ID = PROP.C_ID_TIPO\n" +
            ")\n" +
            ", DATOS_PERMISOS AS (\n" +
            "    SELECT \n" +
            "    PC.C_SOCIEDAD\n" +
            "    ,POR.C_PLANTA\n" +
            "    ,PC.C_ID ID_PERMISO\n" +
            "    ,PC.C_ID_VIAJE ID_VIAJE\n" +
            "    ,PC.C_ESTADO\n" +
            "    ,PC.M_FINAL\n" +
            "    ,PC.c_id_tipo_permiso ID_TIPO_PERMISO\n" +
            "    ,pc.c_id_familia_camion ID_FAM_CAMION\n" +
            "    ,decode(PC.c_id_familia_camion, 02, 'BITREN', 17, 'ESCALABLE', 'ESTANDAR') TIPO_TRANSPORTE\n" +
            "    ,PC.c_id_nodo_actual ID_UBI_ACTUAL\n" +
            "    FROM APT.APT_PERMISO_CIRCULACION PC \n" +
            "        JOIN TIPOS_PER ON TIPOS_PER.C_ID_TIPO = PC.c_id_tipo_permiso\n" +
            "        JOIN PISOPLTA.vw_porterias por on por.ID_PORTERIA = pc.c_id_frente_expedicion \n" +
            "        AND por.c_planta = TIPOS_PER.C_PLANTA\n" +
            "    WHERE pc.F_FECHA_ALTA > (sysdate - 1000)\n" +
            "    and PC.C_ESTADO NOT IN ( 'REC')\n" +
            ")\n" +
            ", PERMISOS_PLANTA AS (\n" +
            "    SELECT \n" +
            "         P.C_SOCIEDAD  --sociedad\n" +
            "         ,P.C_PLANTA  --cPlanta\n" +
            "         ,P.ID_PERMISO  --idPermiso \n" +
            "         ,P.ID_VIAJE  --idViaje\n" +
            "         ,P.C_ESTADO  --estado\n" +
            "         ,P.M_FINAL  --mFinal\n" +
            "         ,P.ID_TIPO_PERMISO  --idTipoPermiso\n" +
            "         ,P.ID_FAM_CAMION  --idFamiliaCamion\n" +
            "         ,P.TIPO_TRANSPORTE  --tipoTransporte\n" +
            "         ,P.ID_UBI_ACTUAL  --idUbicacionActual\n" +
            "        ,NODO.C_UBICACION C_UBI_ACTUAL  --cUbicacionActual\n" +
            "        ,NODO.D_UBICACION D_UBI_ACTUAL  --dUbicacionActual     \n" +
            "        ,(CASE WHEN ( SELECT  COUNT(1)  from vw_zonas_despacho ZD WHERE ZD.id_almacen = P.ID_UBI_ACTUAl ) > 0 THEN 'S' ELSE 'N' END) EN_ZONA_DESPACHO  --enZonaDespacho\n" +
            "        ,(case when ( p.c_estado in ('PRE'))             then 'S' else 'N' end) EN_PORTERIA  --enPorterial\n" +
            "        ,(case when ( p.c_estado in ('INS','ING','PEC')) then 'S' else 'N' end) EN_TRANSITO_INGRESO  --enTransitoIngreso\n" +
            "        ,(case when ( p.c_estado in ('IAN','EIN', 'ECN', 'CAN','CAP','CAR','ESN','ESU')) then 'S' else 'N' end) EN_ALMACEN_PLAYA  --enAlmacenPlaya\n" +
            "        ,(case when ( p.c_estado in ('EGN','CON','PSC','PSR')) then 'S' else 'N' end) EN_TRANSITO_EGRESO  --enTransitoEgreso\n" +
            "        ,(case when ( p.c_estado in ('ISA', 'REM'))            then 'S' else 'N' end) EN_PORTERIA_EGRESO  --enPorteriaEgreso\n" +
            "        ,(case when ( p.ID_UBI_ACTUAl = 405 )                  then 'S' else 'N' end) EN_PUERTO  --enPuerto  \n" +
            "        ,NVL((   select ROUND(sum(ir.n_cantidad) ,3) toneladas \n" +
            "                from apt_remito r\n" +
            "                join apt_item_remito ir on ir.c_id_remito = r.c_id\n" +
            "            WHERE P.ID_PERMISO = r.c_id_permiso    \n" +
            "        ),0) TON_DESPACHADAS  --tonDespachadas             \n" +
            "        ,(select MAX (mp.F_FECHA_HORA) from APT_MOVIMIENTOS_PERMISO mp where mp.c_id_permiso_circulacion = p.ID_PERMISO AND mp.c_id_evento_movimiento = 2) FECHA_PRESENTACION  --fechaPresentacion\n" +
            "        ,(select MAX (mp.F_FECHA_HORA) from APT_MOVIMIENTOS_PERMISO mp where mp.c_id_permiso_circulacion = p.ID_PERMISO AND mp.c_id_evento_movimiento = 4) FECHA_INGRESO  --fechaIngreso\n" +
            "        ,(select MAX (mp.F_FECHA_HORA) from APT_MOVIMIENTOS_PERMISO mp where mp.c_id_permiso_circulacion = p.ID_PERMISO AND mp.c_id_evento_movimiento = 7) FECHA_EGRESO  --fechaEgreso                \n" +
            "FROM DATOS_PERMISOS P\n" +
            "JOIN STK_UBICACION NODO ON NODO.C_ID = P.ID_UBI_ACTUAl) \n" +
            "SELECT * FROM PERMISOS_PLANTA ";


    private String as= "{\n" +
            "  \"accion\": \"CONFIRMAR_UBICACION\",\n" +
            "  \"atributos\": [\n" +
            "    {\n" +
            "      \"id\": \"1\",\n" +
            "      \"nombre\": \"TELEFONO\",\n" +
            "      \"valor\": \"9999\" -> Télefono del conductor\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"1\",\n" +
            "      \"nombre\": \"MENSAJE\",\n" +
            "      \"valor\": \"Favor de confirmar su ubicación para que se le asigne un viaje\" -> Configurar mensaje genérico en property\n" +
            "    }\n" +
            "    {\n" +
            "      \"id\": \"1\",\n" +
            "      \"nombre\": \"ACCIONES\",\n" +
            "      \"valor\": \"UBICACION\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"blob\": []\n" +
            "}";


    private static String fecha = "15/03/2022";
    private static String hora = "00:00-00:00";

    static String jsons = "{\"ENTIDAD\": [\n" +
            "    {\n" +
            "        \"enTransitoIngreso\": \"N\",\n" +
            "        \"estado\": \"DEN\",\n" +
            "        \"idTipoPermiso\": 6,\n" +
            "        \"enTransitoEgreso\": \"N\",\n" +
            "        \"sociedad\": \"TM01\",\n" +
            "        \"mFinal\": \"N\",\n" +
            "        \"enAlmacenPlaya\": \"N\",\n" +
            "        \"fechaPresentacion\": \"2017/06/02-18:42:00\",\n" +
            "        \"fechaEgreso\": \"\",\n" +
            "        \"idViaje\": 381123,\n" +
            "        \"idUbicacionActual\": 173492865,\n" +
            "        \"fechaIngreso\": \"2017/06/02-18:43:00\",\n" +
            "        \"idFamiliaCamion\": 26,\n" +
            "        \"cPlanta\": \"GUE\",\n" +
            "        \"cUbicacionActual\": \"GUEA21A1\",\n" +
            "        \"idPermiso\": 629605,\n" +
            "        \"enPorterial\": \"N\",\n" +
            "        \"dUbicacionActual\": \"Anden 1\",\n" +
            "        \"tonDespachadas\": 0,\n" +
            "        \"enPorteriaEgreso\": \"N\",\n" +
            "        \"enZonaDespacho\": \"N\",\n" +
            "        \"tipoTransporte\": \"ESTANDAR\",\n" +
            "        \"enPuerto\": \"N\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"enTransitoIngreso\": \"N\",\n" +
            "        \"estado\": \"EGR\",\n" +
            "        \"idTipoPermiso\": 2,\n" +
            "        \"enTransitoEgreso\": \"N\",\n" +
            "        \"sociedad\": \"TM01\",\n" +
            "        \"mFinal\": \"S\",\n" +
            "        \"enAlmacenPlaya\": \"N\",\n" +
            "        \"fechaPresentacion\": \"2019/09/10-12:43:00\",\n" +
            "        \"fechaEgreso\": \"2020/06/15-17:48:00\",\n" +
            "        \"idViaje\": 382976,\n" +
            "        \"idUbicacionActual\": 157700447,\n" +
            "        \"fechaIngreso\": \"2019/09/10-12:43:00\",\n" +
            "        \"idFamiliaCamion\": 28,\n" +
            "        \"cPlanta\": \"GUE\",\n" +
            "        \"cUbicacionActual\": \"GUE-PORT2\",\n" +
            "        \"idPermiso\": 631980,\n" +
            "        \"enPorterial\": \"N\",\n" +
            "        \"dUbicacionActual\": \"Gue. Av. Guerrero\",\n" +
            "        \"tonDespachadas\": 57,\n" +
            "        \"enPorteriaEgreso\": \"N\",\n" +
            "        \"enZonaDespacho\": \"N\",\n" +
            "        \"tipoTransporte\": \"ESTANDAR\",\n" +
            "        \"enPuerto\": \"N\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"enTransitoIngreso\": \"N\",\n" +
            "        \"estado\": \"EGR\",\n" +
            "        \"idTipoPermiso\": 3,\n" +
            "        \"enTransitoEgreso\": \"N\",\n" +
            "        \"sociedad\": \"TM01\",\n" +
            "        \"mFinal\": \"S\",\n" +
            "        \"enAlmacenPlaya\": \"N\",\n" +
            "        \"fechaPresentacion\": \"2020/06/23-10:17:00\",\n" +
            "        \"fechaEgreso\": \"2020/06/23-10:23:00\",\n" +
            "        \"idViaje\": 382984,\n" +
            "        \"idUbicacionActual\": 157700447,\n" +
            "        \"fechaIngreso\": \"2020/06/23-10:18:00\",\n" +
            "        \"idFamiliaCamion\": 28,\n" +
            "        \"cPlanta\": \"GUE\",\n" +
            "        \"cUbicacionActual\": \"GUE-PORT2\",\n" +
            "        \"idPermiso\": 632811,\n" +
            "        \"enPorterial\": \"N\",\n" +
            "        \"dUbicacionActual\": \"Gue. Av. Guerrero\",\n" +
            "        \"tonDespachadas\": 41.89,\n" +
            "        \"enPorteriaEgreso\": \"N\",\n" +
            "        \"enZonaDespacho\": \"N\",\n" +
            "        \"tipoTransporte\": \"ESTANDAR\",\n" +
            "        \"enPuerto\": \"N\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"enTransitoIngreso\": \"N\",\n" +
            "        \"estado\": \"EGR\",\n" +
            "        \"idTipoPermiso\": 3,\n" +
            "        \"enTransitoEgreso\": \"N\",\n" +
            "        \"sociedad\": \"TM01\",\n" +
            "        \"mFinal\": \"S\",\n" +
            "        \"enAlmacenPlaya\": \"N\",\n" +
            "        \"fechaPresentacion\": \"2020/06/19-16:42:00\",\n" +
            "        \"fechaEgreso\": \"2020/06/19-16:47:00\",\n" +
            "        \"idViaje\": 382981,\n" +
            "        \"idUbicacionActual\": 157700447,\n" +
            "        \"fechaIngreso\": \"2020/06/19-16:42:00\",\n" +
            "        \"idFamiliaCamion\": 28,\n" +
            "        \"cPlanta\": \"GUE\",\n" +
            "        \"cUbicacionActual\": \"GUE-PORT2\",\n" +
            "        \"idPermiso\": 632805,\n" +
            "        \"enPorterial\": \"N\",\n" +
            "        \"dUbicacionActual\": \"Gue. Av. Guerrero\",\n" +
            "        \"tonDespachadas\": 32,\n" +
            "        \"enPorteriaEgreso\": \"N\",\n" +
            "        \"enZonaDespacho\": \"N\",\n" +
            "        \"tipoTransporte\": \"ESTANDAR\",\n" +
            "        \"enPuerto\": \"N\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"enTransitoIngreso\": \"N\",\n" +
            "        \"estado\": \"EGR\",\n" +
            "        \"idTipoPermiso\": 2,\n" +
            "        \"enTransitoEgreso\": \"N\",\n" +
            "        \"sociedad\": \"TM01\",\n" +
            "        \"mFinal\": \"S\",\n" +
            "        \"enAlmacenPlaya\": \"N\",\n" +
            "        \"fechaPresentacion\": \"2021/01/28-08:55:00\",\n" +
            "        \"fechaEgreso\": \"2021/05/28-13:03:00\",\n" +
            "        \"idViaje\": \"\",\n" +
            "        \"idUbicacionActual\": 157700448,\n" +
            "        \"fechaIngreso\": \"2021/05/28-13:03:00\",\n" +
            "        \"idFamiliaCamion\": 28,\n" +
            "        \"cPlanta\": \"GUE\",\n" +
            "        \"cUbicacionActual\": \"GUE-PORT3\",\n" +
            "        \"idPermiso\": 633023,\n" +
            "        \"enPorterial\": \"N\",\n" +
            "        \"dUbicacionActual\": \"Gue. Privada Famosa\",\n" +
            "        \"tonDespachadas\": 0,\n" +
            "        \"enPorteriaEgreso\": \"N\",\n" +
            "        \"enZonaDespacho\": \"N\",\n" +
            "        \"tipoTransporte\": \"ESTANDAR\",\n" +
            "        \"enPuerto\": \"N\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"enTransitoIngreso\": \"N\",\n" +
            "        \"estado\": \"EGR\",\n" +
            "        \"idTipoPermiso\": 3,\n" +
            "        \"enTransitoEgreso\": \"N\",\n" +
            "        \"sociedad\": \"TM01\",\n" +
            "        \"mFinal\": \"S\",\n" +
            "        \"enAlmacenPlaya\": \"N\",\n" +
            "        \"fechaPresentacion\": \"2020/11/13-10:30:00\",\n" +
            "        \"fechaEgreso\": \"2020/11/13-18:38:00\",\n" +
            "        \"idViaje\": 383126,\n" +
            "        \"idUbicacionActual\": 157700447,\n" +
            "        \"fechaIngreso\": \"2020/11/13-10:31:00\",\n" +
            "        \"idFamiliaCamion\": 28,\n" +
            "        \"cPlanta\": \"GUE\",\n" +
            "        \"cUbicacionActual\": \"GUE-PORT2\",\n" +
            "        \"idPermiso\": 632894,\n" +
            "        \"enPorterial\": \"N\",\n" +
            "        \"dUbicacionActual\": \"Gue. Av. Guerrero\",\n" +
            "        \"tonDespachadas\": 34.46,\n" +
            "        \"enPorteriaEgreso\": \"N\",\n" +
            "        \"enZonaDespacho\": \"N\",\n" +
            "        \"tipoTransporte\": \"ESTANDAR\",\n" +
            "        \"enPuerto\": \"N\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"enTransitoIngreso\": \"N\",\n" +
            "        \"estado\": \"EGR\",\n" +
            "        \"idTipoPermiso\": 2,\n" +
            "        \"enTransitoEgreso\": \"N\",\n" +
            "        \"sociedad\": \"TM01\",\n" +
            "        \"mFinal\": \"S\",\n" +
            "        \"enAlmacenPlaya\": \"N\",\n" +
            "        \"fechaPresentacion\": \"2020/10/26-19:17:00\",\n" +
            "        \"fechaEgreso\": \"2020/10/27-08:54:00\",\n" +
            "        \"idViaje\": 383073,\n" +
            "        \"idUbicacionActual\": 157700447,\n" +
            "        \"fechaIngreso\": \"2020/10/26-19:17:00\",\n" +
            "        \"idFamiliaCamion\": 26,\n" +
            "        \"cPlanta\": \"GUE\",\n" +
            "        \"cUbicacionActual\": \"GUE-PORT2\",\n" +
            "        \"idPermiso\": 632887,\n" +
            "        \"enPorterial\": \"N\",\n" +
            "        \"dUbicacionActual\": \"Gue. Av. Guerrero\",\n" +
            "        \"tonDespachadas\": 32,\n" +
            "        \"enPorteriaEgreso\": \"N\",\n" +
            "        \"enZonaDespacho\": \"N\",\n" +
            "        \"tipoTransporte\": \"ESTANDAR\",\n" +
            "        \"enPuerto\": \"N\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"enTransitoIngreso\": \"N\",\n" +
            "        \"estado\": \"EGR\",\n" +
            "        \"idTipoPermiso\": 3,\n" +
            "        \"enTransitoEgreso\": \"N\",\n" +
            "        \"sociedad\": \"TM01\",\n" +
            "        \"mFinal\": \"S\",\n" +
            "        \"enAlmacenPlaya\": \"N\",\n" +
            "        \"fechaPresentacion\": \"2021/06/17-10:05:02\",\n" +
            "        \"fechaEgreso\": \"2021/06/17-15:03:00\",\n" +
            "        \"idViaje\": 383620,\n" +
            "        \"idUbicacionActual\": 157700446,\n" +
            "        \"fechaIngreso\": \"2021/06/17-10:05:00\",\n" +
            "        \"idFamiliaCamion\": 27,\n" +
            "        \"cPlanta\": \"GUE\",\n" +
            "        \"cUbicacionActual\": \"GUE-PORT1\",\n" +
            "        \"idPermiso\": 633229,\n" +
            "        \"enPorterial\": \"N\",\n" +
            "        \"dUbicacionActual\": \"Gue. Av. Los Angeles\",\n" +
            "        \"tonDespachadas\": 43.57,\n" +
            "        \"enPorteriaEgreso\": \"N\",\n" +
            "        \"enZonaDespacho\": \"N\",\n" +
            "        \"tipoTransporte\": \"ESTANDAR\",\n" +
            "        \"enPuerto\": \"N\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"enTransitoIngreso\": \"N\",\n" +
            "        \"estado\": \"ISA\",\n" +
            "        \"idTipoPermiso\": 3,\n" +
            "        \"enTransitoEgreso\": \"N\",\n" +
            "        \"sociedad\": \"TM01\",\n" +
            "        \"mFinal\": \"N\",\n" +
            "        \"enAlmacenPlaya\": \"N\",\n" +
            "        \"fechaPresentacion\": \"2021/06/24-17:39:39\",\n" +
            "        \"fechaEgreso\": \"2021/06/24-17:44:00\",\n" +
            "        \"idViaje\": \"\",\n" +
            "        \"idUbicacionActual\": 157700447,\n" +
            "        \"fechaIngreso\": \"2021/06/24-17:39:00\",\n" +
            "        \"idFamiliaCamion\": 27,\n" +
            "        \"cPlanta\": \"GUE\",\n" +
            "        \"cUbicacionActual\": \"GUE-PORT2\",\n" +
            "        \"idPermiso\": 633233,\n" +
            "        \"enPorterial\": \"N\",\n" +
            "        \"dUbicacionActual\": \"Gue. Av. Guerrero\",\n" +
            "        \"tonDespachadas\": 43.33,\n" +
            "        \"enPorteriaEgreso\": \"S\",\n" +
            "        \"enZonaDespacho\": \"N\",\n" +
            "        \"tipoTransporte\": \"ESTANDAR\",\n" +
            "        \"enPuerto\": \"N\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"enTransitoIngreso\": \"N\",\n" +
            "        \"estado\": \"EGR\",\n" +
            "        \"idTipoPermiso\": 3,\n" +
            "        \"enTransitoEgreso\": \"N\",\n" +
            "        \"sociedad\": \"TM01\",\n" +
            "        \"mFinal\": \"S\",\n" +
            "        \"enAlmacenPlaya\": \"N\",\n" +
            "        \"fechaPresentacion\": \"2021/07/01-11:41:30\",\n" +
            "        \"fechaEgreso\": \"2021/07/01-11:51:00\",\n" +
            "        \"idViaje\": 383687,\n" +
            "        \"idUbicacionActual\": 157700447,\n" +
            "        \"fechaIngreso\": \"2021/07/01-11:41:00\",\n" +
            "        \"idFamiliaCamion\": 27,\n" +
            "        \"cPlanta\": \"GUE\",\n" +
            "        \"cUbicacionActual\": \"GUE-PORT2\",\n" +
            "        \"idPermiso\": 633239,\n" +
            "        \"enPorterial\": \"N\",\n" +
            "        \"dUbicacionActual\": \"Gue. Av. Guerrero\",\n" +
            "        \"tonDespachadas\": 14,\n" +
            "        \"enPorteriaEgreso\": \"N\",\n" +
            "        \"enZonaDespacho\": \"N\",\n" +
            "        \"tipoTransporte\": \"ESTANDAR\",\n" +
            "        \"enPuerto\": \"N\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"enTransitoIngreso\": \"N\",\n" +
            "        \"estado\": \"EGR\",\n" +
            "        \"idTipoPermiso\": 3,\n" +
            "        \"enTransitoEgreso\": \"N\",\n" +
            "        \"sociedad\": \"TM01\",\n" +
            "        \"mFinal\": \"S\",\n" +
            "        \"enAlmacenPlaya\": \"N\",\n" +
            "        \"fechaPresentacion\": \"2021/07/01-12:12:15\",\n" +
            "        \"fechaEgreso\": \"2021/07/01-12:19:00\",\n" +
            "        \"idViaje\": 383688,\n" +
            "        \"idUbicacionActual\": 157700447,\n" +
            "        \"fechaIngreso\": \"2021/07/01-12:12:00\",\n" +
            "        \"idFamiliaCamion\": 26,\n" +
            "        \"cPlanta\": \"GUE\",\n" +
            "        \"cUbicacionActual\": \"GUE-PORT2\",\n" +
            "        \"idPermiso\": 633241,\n" +
            "        \"enPorterial\": \"N\",\n" +
            "        \"dUbicacionActual\": \"Gue. Av. Guerrero\",\n" +
            "        \"tonDespachadas\": 48,\n" +
            "        \"enPorteriaEgreso\": \"N\",\n" +
            "        \"enZonaDespacho\": \"N\",\n" +
            "        \"tipoTransporte\": \"ESTANDAR\",\n" +
            "        \"enPuerto\": \"N\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"enTransitoIngreso\": \"N\",\n" +
            "        \"estado\": \"EGR\",\n" +
            "        \"idTipoPermiso\": 3,\n" +
            "        \"enTransitoEgreso\": \"N\",\n" +
            "        \"sociedad\": \"TM01\",\n" +
            "        \"mFinal\": \"S\",\n" +
            "        \"enAlmacenPlaya\": \"N\",\n" +
            "        \"fechaPresentacion\": \"2021/06/16-20:06:38\",\n" +
            "        \"fechaEgreso\": \"\",\n" +
            "        \"idViaje\": 383612,\n" +
            "        \"idUbicacionActual\": 157700894,\n" +
            "        \"fechaIngreso\": \"2021/06/16-20:06:00\",\n" +
            "        \"idFamiliaCamion\": 28,\n" +
            "        \"cPlanta\": \"GUE\",\n" +
            "        \"cUbicacionActual\": \"GUEA6G\",\n" +
            "        \"idPermiso\": 633226,\n" +
            "        \"enPorterial\": \"N\",\n" +
            "        \"dUbicacionActual\": \"Area 6 Gruas\",\n" +
            "        \"tonDespachadas\": 0,\n" +
            "        \"enPorteriaEgreso\": \"N\",\n" +
            "        \"enZonaDespacho\": \"N\",\n" +
            "        \"tipoTransporte\": \"ESTANDAR\",\n" +
            "        \"enPuerto\": \"N\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"enTransitoIngreso\": \"N\",\n" +
            "        \"estado\": \"EGR\",\n" +
            "        \"idTipoPermiso\": 2,\n" +
            "        \"enTransitoEgreso\": \"N\",\n" +
            "        \"sociedad\": \"TM01\",\n" +
            "        \"mFinal\": \"S\",\n" +
            "        \"enAlmacenPlaya\": \"N\",\n" +
            "        \"fechaPresentacion\": \"2021/09/15-11:14:51\",\n" +
            "        \"fechaEgreso\": \"\",\n" +
            "        \"idViaje\": \"\",\n" +
            "        \"idUbicacionActual\": 157700447,\n" +
            "        \"fechaIngreso\": \"2021/09/15-11:18:00\",\n" +
            "        \"idFamiliaCamion\": 28,\n" +
            "        \"cPlanta\": \"GUE\",\n" +
            "        \"cUbicacionActual\": \"GUE-PORT2\",\n" +
            "        \"idPermiso\": 633298,\n" +
            "        \"enPorterial\": \"N\",\n" +
            "        \"dUbicacionActual\": \"Gue. Av. Guerrero\",\n" +
            "        \"tonDespachadas\": 0,\n" +
            "        \"enPorteriaEgreso\": \"N\",\n" +
            "        \"enZonaDespacho\": \"N\",\n" +
            "        \"tipoTransporte\": \"ESTANDAR\",\n" +
            "        \"enPuerto\": \"N\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"enTransitoIngreso\": \"N\",\n" +
            "        \"estado\": \"EGR\",\n" +
            "        \"idTipoPermiso\": 3,\n" +
            "        \"enTransitoEgreso\": \"N\",\n" +
            "        \"sociedad\": \"TM01\",\n" +
            "        \"mFinal\": \"S\",\n" +
            "        \"enAlmacenPlaya\": \"N\",\n" +
            "        \"fechaPresentacion\": \"2022/01/06-16:25:00\",\n" +
            "        \"fechaEgreso\": \"2022/01/07-14:50:00\",\n" +
            "        \"idViaje\": 383902,\n" +
            "        \"idUbicacionActual\": 157700447,\n" +
            "        \"fechaIngreso\": \"2022/01/06-16:35:00\",\n" +
            "        \"idFamiliaCamion\": 28,\n" +
            "        \"cPlanta\": \"GUE\",\n" +
            "        \"cUbicacionActual\": \"GUE-PORT2\",\n" +
            "        \"idPermiso\": 633359,\n" +
            "        \"enPorterial\": \"N\",\n" +
            "        \"dUbicacionActual\": \"Gue. Av. Guerrero\",\n" +
            "        \"tonDespachadas\": 40,\n" +
            "        \"enPorteriaEgreso\": \"N\",\n" +
            "        \"enZonaDespacho\": \"N\",\n" +
            "        \"tipoTransporte\": \"ESTANDAR\",\n" +
            "        \"enPuerto\": \"N\"\n" +
            "    }\n" +
            "]}";

    public static Void execute() throws JsonProcessingException {
        String[] fechas = null;
        String[] horas = null;

        System.out.println(jsons.replace("  ","").replace("\n",""));




        if (fechas != null && fechas.length > 0 && horas != null && horas.length > 0){

        }

        List<String> datos = new ArrayList<>();
        datos.add(fecha);
        datos.add(hora);
        Map<String, String[]> result = new HashMap<>();
        if (!datos.isEmpty()) {
            for(String att : datos){
                if ("15/03/2022".equalsIgnoreCase(att)){
                    String []  split  = att.split(";");
                    result.put("FECHA",split);
                }
                if ("00:00-00:00".equalsIgnoreCase(att)){
                    String [] split = att.split("-");
                    result.put("HORA",split);
                }
            }


            String [] uno = result.get("FECHA");
            String [] dos = result.get("HORA");

            String valor = uno[0] + " "+dos[0];
            String valor2 = (uno.length > 1 ? uno[1] : uno[0]) + " " + dos[1];

            System.out.println(valor + ";" + valor2);
        }



        DateFormat fecha = new SimpleDateFormat("dd-MM-yy HH:SS");

        Calendar calendar = Calendar.getInstance();
        Date date = new Date("2019-09-1012:43:00");



        ArrayList<Object[]> list = new ArrayList<>();

        Object[] rows = new Object[3];
        rows[0] = "chu";
        rows[1] = "chupne";
        rows[2] = "chupnew";

        list.add(rows);
        Object[] row2 = new Object[3];

        row2[0] = "psq";
        row2[1] = "psqne";
        row2[2] = "psqneasd";

        list.add(row2);


        Object[] row3 = new Object[3];

        row3[0] = "gue";
        row3[1] = "guemea";
        row3[2] = "guemeasas";

        list.add(row3);

        List<String> fields = new ArrayList<String>();
        Matcher m = Pattern.compile("--\\w{1,}").matcher(sql);
        while (m.find()) {
            String field =  m.group().replace("--","");
            fields.add(field.trim());
        }

        //System.out.println(fields);
        JSONArray myObject2 = new JSONArray ();
        JSONObject myObject3 = new JSONObject ();
        for (Object[] row :list){
            JSONObject myObject = new JSONObject();
            for (int i = 0 ; i< fields.size() ; i++) {
                myObject.put(fields.get(i), row[i]);
            }
            myObject2.put(myObject);
        }

        myObject3.put("result",myObject2);
        System.out.println(myObject3.toString(4).replaceAll("\\s",""));

        ObjectMapper objectMapper = new ObjectMapper();
        String  json = objectMapper.writeValueAsString(myObject2);
       System.out.println(json);



        JSONObject xmlJSONObj = XML.toJSONObject(xml);
        String string = xmlJSONObj.toString(4);
        //System.out.println(string);
        List<AtributoKpiInVo> attr = new ArrayList<>();
        AtributoKpiInVo vos = new AtributoKpiInVo("permiso","3");
        attr.add(vos);
        vos = new AtributoKpiInVo("estados","[3,4,5]");
        attr.add(vos);
        vos = new AtributoKpiInVo("planta","SN");
        attr.add(vos);
        vos = new AtributoKpiInVo("dispositivo","PSQ_DSP1");
        attr.add(vos);
        vo.setAtributos(attr);
/*
        if (kpi != null){
            Map<String, Object> result;
            Map<String, Object> resguardo;
            Map<String, Object> res;
            try {
                result = new ObjectMapper().readValue(parametros, HashMap.class);
                resguardo = result;
            } catch (Exception e) {
                return null;
            }

            res = calcularVo(result);
            StringBuilder sql = new StringBuilder(kpi);
            procesarParametro(resguardo,res,sql);

        }
*/
        return null;
    }

    private static Map<String, Object> calcularVo( Map<String, Object> result) throws JsonProcessingException {
        LinkedHashMap<String,Object> pares = new LinkedHashMap<>();
        for (Map.Entry<String, Object> params : result.entrySet()) {
            if (params.getKey().equalsIgnoreCase("parametros")){
                ObjectMapper objectMapper = new ObjectMapper();
                String  json = objectMapper.writeValueAsString(params);
                try {
                    for (LinkedHashMap<String,Object> par: (ArrayList<LinkedHashMap>)( params.getValue())) {
                        for(Map.Entry<String, Object> a : par.entrySet()){
                            a.setValue(calcularAtributosRequeridoValor(a.getKey()));
                            pares.put(a.getKey(),a.getValue());
                        }
                    }
                }catch (Exception e){
                }
            }
        }
        return pares;

    }

    protected static String calcularAtributosRequeridoValor(String atributo) {
        String atributosCalculado = null;
        List<AtributoKpiInVo> attrs = vo.getAtributos();
        for (AtributoKpiInVo attr : attrs) {
            if (atributo.equalsIgnoreCase(attr.getAtributo())) {
                atributosCalculado = attr.getValor();
                break;
            }
        }
        return atributosCalculado;
    }

    private static void procesarParametro(Map<String, Object> result,Map<String, Object> res , StringBuilder kpiSql) {
        if(res != null && !res.entrySet().isEmpty()) {
            List<Object> parametros = new ArrayList<>();
                for(Map.Entry<String, Object> parametro : res.entrySet()){
                    if( parametro.getValue() != null){
                        parametros.add( calcularTipo(parametro.getValue()));
                    }
                }

            if(!parametros.isEmpty()) {
                replaceParameters(parametros, kpiSql);
            }
        }
    }

    public static String replaceParameters(List parametros,StringBuilder query){
        String queryString = "";

        Iterator iter = parametros.iterator();
        while (iter.hasNext()) { // reemplazo signos ? por las variables
            int reemplFil = query.indexOf("?");
            Object obj =  iter.next();
            String valor = null;
            if ( obj != null){
                if ( obj instanceof StringBuilder){
                    valor = ((StringBuilder)obj).toString();
                }
                else if  ( obj instanceof String){ //Si es número debe contener las comillas simples
                    valor = "'"+obj+"'";
                }else if ( isCollection ( obj) ){  //Validando si es una colección
                    Collection col = ( Collection ) obj;
                    if ( !col.isEmpty() ){
                        Object obCol 	  = col.iterator().next();
                        if ( obCol instanceof String){  //Si es String debe contener una comilla simple
                            valor = collectionToString(col, ",", "'");
                        }else{
                            valor = collectionToString(col, ",");
                        }
                    }
                }else{
                    valor = obj.toString();
                }
                if ( valor != null){
                    valor = valor.replace(",'0'", "");
                }
            }
            query.deleteCharAt(reemplFil);
            query.insert(reemplFil, valor);
            //}
        }
        queryString = query.toString();
        //logger.info("replaceParameterIntoView - Vista Out: " + queryString);
        return queryString;
    }

    public static boolean isCollection(Object object){
        boolean isCollection = false;
        try {
            if ( object != null){
                Collection c = (Collection) object;
                isCollection = true;
            }
        }catch (Throwable e){

        }
        return isCollection;
    }

    public static String collectionToString(Collection<?> col, String separator, String demarcador) {
        StringBuffer sb = new StringBuffer();
        boolean bdemarcador = !StringUtils.isEmpty(demarcador);
        if (col != null) {
            for (Iterator<?> iterator = col.iterator(); iterator.hasNext();) {
                Object s = (Object) iterator.next();
                if(s!=null)  {
                    if (bdemarcador) { sb.append(demarcador);}
                    if(s instanceof String) {
                        sb.append((String)s);
                    }
                    else if (s instanceof BigDecimal){
                        sb.append(((BigDecimal)s).toString());
                    }else{
                        sb.append(s.toString());
                    }
                    if (bdemarcador) {sb.append(demarcador);}
                    if (iterator.hasNext()) {
                        sb.append(separator);
                    }
                }
            }
        }
        return sb.toString();
    }

    public static String collectionToString(Collection<?> col, String separator) {
        return collectionToString(col, separator, null);
    }

    public static List<Object> calcularTipo(Object B ){
        String a = B.toString();
        a= a.replace("[","");
        a = a.replace("]","");
        return new ArrayList<>(Arrays.asList(a.split(",")));
    }

}
