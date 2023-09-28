/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.view;

import com.controladores.Login;
import com.controladores.crud;
import com.controladores.datos;
import com.controladores.datos.huesped;
import com.controladores.datos.reserva;
import com.controladores.db;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author braya
 */
public class panel extends javax.swing.JPanel {

    private double x = 0;
    private double y = 0;
    private LocalDate ingresa;
    private LocalDate sale;
    private double val;
    private String Tpago;
    private static int identificador;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Pane FullRes;
    @FXML
    private PasswordField C;
    @FXML
    private TextField User;
    @FXML
    private Pane alerta;

    @FXML
    private DatePicker in;

    @FXML
    private DatePicker out;

    @FXML
    private ComboBox pay = new ComboBox<>();

    @FXML
    private Label valres;
    @FXML
    private TextField Nreservas;

    @FXML
    private TextField apelli;
    @FXML
    private DatePicker naci;

    @FXML
    private TextField nacional;

    @FXML
    private TextField name;
    @FXML
    private TextField inputbusca;

    @FXML
    private TextField tel;
    @FXML
    private Button del;
    @FXML
    private TableView<datos.reserva> reservaTabla;
    @FXML
    private TableColumn<datos.reserva, String> NumeroR;

    @FXML
    private TableColumn<datos.reserva, String> TipoPago;

    @FXML
    private TableColumn<datos.reserva, String> fechain;

    @FXML
    private TableColumn<datos.reserva, String> fechaout;

    @FXML
    private TableColumn<datos.reserva, String> valor;
    @FXML
    private TableView<datos.huesped> htabla;
    @FXML
    private TableColumn<datos.huesped, String> numeroCo;
    @FXML
    private TableColumn<datos.huesped, String> nameCo;
    @FXML
    private TableColumn<datos.huesped, String> apellidoCo;

    @FXML
    private TableColumn<datos.huesped, String> nacidoCo;

    @FXML
    private TableColumn<datos.huesped, String> paisCo;

    @FXML
    private TableColumn<datos.huesped, String> telCo;

    public panel() {
        initComponents();
    }

    @FXML
    public void initialize() {
        pay.getItems().addAll("Tarjeta Debito", "Tarjeta Credito", "Efectivo");
      //  del.setOnAction(e -> deleteSelectedRow());
        this.del = new Button();
        this.inputbusca = new TextField();
        this.telCo = new TableColumn();
        this.paisCo = new TableColumn();
        this.nacidoCo = new TableColumn();
        this.apellidoCo = new TableColumn();
        this.nameCo = new TableColumn();
        this.numeroCo = new TableColumn();
        this.htabla = new TableView();
        this.valor = new TableColumn();
        this.fechaout = new TableColumn();
        this.fechain = new TableColumn();
        this.TipoPago = new TableColumn();
        this.reservaTabla = new TableView();
        this.NumeroR = new TableColumn();
         Cargador("reserva", null);
    }

    private void deleteSelectedRow() {
        reserva selectedItem = reservaTabla.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String id = selectedItem.getId(); // Get the ID
            reservaTabla.getItems().remove(selectedItem);
            db dbConnection = new db();
            Connection connection = dbConnection.getConnection();
            if (connection != null) {
                crud erase = new crud();
                boolean autenticado = erase.Elimina(connection, id);
                if (autenticado) {
                    System.out.println("Inicio de sesión exitoso. ¡Bienvenido!");
                } else {
                    System.out.println("Inicio de sesión fallido. Nombre de usuario o contraseña incorrectos.");
                    alerta.setVisible(true);
                }
                dbConnection.closeConnection();
            } else {
                System.out.println("No se pudo conectar a la base de datos.");
            }
        }
    }

    @FXML
    private void bordeMove(MouseEvent event
    ) {
        Stage stage = (Stage) AnchorPane.getScene().getWindow();
        stage.setY(event.getScreenY() - y);
        stage.setX(event.getScreenX() - x);
    }

    @FXML
    private void bordePress(MouseEvent event
    ) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    void exit(MouseEvent event
    ) {
        System.exit(0);
    }

    @FXML
    void logearse(MouseEvent event) throws IOException {
        System.out.println(" login\n");
        Pages("login");
    }

    private void Pages(String dato) throws IOException {
        FullRes.getChildren().clear();
        Node add = FXMLLoader.load(panel.class.getResource("/fx/" + dato + ".fxml"));
        FullRes.getChildren().add(add);
    }

    @FXML
    void regestra(MouseEvent event) throws IOException {
        Pages("registre");
    }

    @FXML
    void back(MouseEvent event) throws IOException {
        Pages("fxH");
    }

    @FXML
    void Logeando(MouseEvent event) throws IOException {
        String contraseñaUsuario = C.getText();
        String nombreUsuario = User.getText();
        db dbConnection = new db();
        Connection connection = dbConnection.getConnection();
        if (connection != null) {
            Login login = new Login();
            boolean autenticado = login.verificarCredenciales(connection, nombreUsuario, contraseñaUsuario);
            if (autenticado) {
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido!");
                Pages("home");
            } else {
                System.out.println("Inicio de sesión fallido. Nombre de usuario o contraseña incorrectos.");
                alerta.setVisible(true);
            }
            dbConnection.closeConnection();
        } else {
            System.out.println("No se pudo conectar a la base de datos.");
        }
    }

    @FXML
    void Reservacion(MouseEvent event) throws IOException {
        Pages("reserva");
    }

    @FXML
    void listenpiker(ActionEvent event) {
        ingresa = in.getValue();
        sale = out.getValue();
        if (ingresa != null && sale != null) {
            long differenceInDays = java.time.temporal.ChronoUnit.DAYS.between(ingresa, sale);
            val = differenceInDays * 10;
            String strNumber = Double.toString(val);
            valres.setText("  $" + strNumber);
            valres.getStyleClass().add("active");
            System.out.println("Difference in days: " + differenceInDays + " / pago :" + val);
        }
    }

    public void Piker() {

    }

    @FXML
    void search(MouseEvent event) throws IOException {
        Pages("busca");
           Cargador("reserva", null);
    }

    void Cargador(String tipo, String kbusca) {
        db dbConnection = new db();
        Connection connection = dbConnection.getConnection();
        datos datosInstance = new datos();
        try {
            if (connection != null) {
                crud fetch = new crud();
                ResultSet reservas = fetch.fetch(connection, tipo, kbusca);
                ObservableList<datos.reserva> reservasData = FXCollections.observableArrayList();
                ObservableList<datos.huesped> huespedData = FXCollections.observableArrayList();
                reservaTabla.getColumns().clear();
                htabla.getColumns().clear();
                while (reservas.next()) {
                    datos.reserva reservaInstance = datosInstance.new reserva(reservas.getString("id"), reservas.getString("ingresa"), reservas.getString("sale"), reservas.getString("valor"), reservas.getString("Formapago"));
                    reservasData.add(reservaInstance);
                    datos.huesped huespedInstance = datosInstance.new huesped(reservas.getString("nreserva"), reservas.getString("nombre"), reservas.getString("apellido"), reservas.getString("nacimiento"), reservas.getString("nacionalidad"), reservas.getString("telefono"));
                    huespedData.add(huespedInstance);
                    System.out.println(huespedInstance);
                }
                NumeroR.setCellValueFactory(new PropertyValueFactory<>("id"));
                fechain.setCellValueFactory(new PropertyValueFactory<>("in"));
                fechaout.setCellValueFactory(new PropertyValueFactory<>("sale"));
                valor.setCellValueFactory(new PropertyValueFactory<>("valor"));
                TipoPago.setCellValueFactory(new PropertyValueFactory<>("pago"));
                reservaTabla.getColumns().addAll(NumeroR, fechain, fechaout, valor, TipoPago);
                reservaTabla.setItems(reservasData);
                numeroCo.setCellValueFactory(new PropertyValueFactory<>("nreserva"));
                nameCo.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                apellidoCo.setCellValueFactory(new PropertyValueFactory<>("apellido"));
                nacidoCo.setCellValueFactory(new PropertyValueFactory<>("nacimiento"));
                paisCo.setCellValueFactory(new PropertyValueFactory<>("nacionalidad"));
                telCo.setCellValueFactory(new PropertyValueFactory<>("telefono"));
                htabla.getColumns().addAll(numeroCo, nameCo, apellidoCo, nacidoCo, paisCo, telCo);
                htabla.setItems(huespedData);
                System.out.println(numeroCo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(panel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnection.closeConnection();
        }
    }

    @FXML
    void minclose(MouseEvent event) {
        alerta.setVisible(false);
    }

    @FXML
    void backHome(MouseEvent event) throws IOException {
        Pages("home");
    }

    @FXML
    void inserta(MouseEvent event) throws IOException, ParseException {
        ingresa = in.getValue();
        sale = out.getValue();
        Tpago = (String) pay.getValue();
        db dbConnection = new db();
        Connection connection = dbConnection.getConnection();
        if (connection != null) {
            crud inserta = new crud();
            String entrada = ingresa.toString();
            String salida = sale.toString();
            int insertado = inserta.reserva(connection, "reserva", entrada, salida, Tpago, val);
            if (insertado > 0) {
                identificador = insertado;
                setLoggedInUser(identificador);
                Pages("registre");
            } else {
                System.out.println("Inicio de sesión fallido. Nombre de usuario o contraseña incorrectos.");
                alerta.setVisible(true);
            }
            dbConnection.closeConnection();
        } else {
            System.out.println("No se pudo conectar a la base de datos.");
        }
    }

    @FXML
    void restrando(MouseEvent event) throws ParseException, IOException {
        db dbConnection = new db();
        Connection connection = dbConnection.getConnection();
        if (connection != null) {
            crud h = new crud();
            String nome = name.getText();
            String apellido = apelli.getText();
            LocalDate nc = naci.getValue();
            String nacido = nc.toString();
            String nan = nacional.getText();
            String telefono = tel.getText();
            boolean insertado = h.huesped(connection, "huesped", nome, apellido, nacido, nan, telefono, identificador);
            if (insertado) {
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido!");
                System.out.println("Last Inserted ID: " + insertado);
                clearSession();
                Pages("busca");
            } else {
                System.out.println("Inicio de sesión fallido. Nombre de usuario o contraseña incorrectos.");
            }
            dbConnection.closeConnection();
        } else {
            System.out.println("No se pudo conectar a la base de datos.");
        }
    }

    public static void setLoggedInUser(int id) {
        identificador = id;
    }

    public static void clearSession() {
        identificador = 0;
    }

    @FXML
    void buscando(MouseEvent event) {
        Cargador("buscador", inputbusca.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setToolTipText("");
        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
