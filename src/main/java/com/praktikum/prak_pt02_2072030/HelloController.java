package com.praktikum.prak_pt02_2072030;

import com.praktikum.prak_pt02_2072030.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class HelloController {
    @FXML
    private TableView<Student> table;
    @FXML
    private TableColumn<Integer, Student> col1;
    @FXML
    private TableColumn<String, Student> col2;
    @FXML
    private TableColumn<Float, Student> col3;
    @FXML
    private TableColumn<Float, Student> col4;
    @FXML
    private TextField nrp;
    @FXML
    private TextField nama;
    @FXML
    private TextField ipa;
    @FXML
    private TextField ips;
    @FXML
    public Button btnAdd;
    @FXML
    public Button btnUpdate;
    @FXML
    public Button btnDel;

    public int idx;
    public ObservableList<Student> sList;

    public void initialize() {
        sList = FXCollections.observableArrayList(
                new Student(1, "Juan", 40, 30),
                new Student(2, "Andi", 50, 50),
                new Student(3, "Budi", 20, 10),
                new Student(4, "Kevin", 80, 70),
                new Student(5, "Michael", 90, 60)
        );
        table.setItems(sList);
        col1.setCellValueFactory(new PropertyValueFactory<>("nrp"));
        col2.setCellValueFactory(new PropertyValueFactory<>("nama"));
        col3.setCellValueFactory(new PropertyValueFactory<>("ipa"));
        col4.setCellValueFactory(new PropertyValueFactory<>("ips"));
    }
    public void reset(){
        nrp.clear();
        nama.clear();
        ipa.clear();
        ips.clear();
        btnAdd.setDisable(false);
        btnUpdate.setDisable(false);
        btnDel.setDisable(false);
    }
    public void getSelectedItem(MouseEvent mouseEvent) {
        if (!table.getSelectionModel().getSelectedCells().isEmpty()) {
            btnAdd.setDisable(true);
            btnUpdate.setDisable(false);
            btnDel.setDisable(false);
            idx = table.getSelectionModel().getSelectedIndex();
        }
        nrp.setText(String.valueOf(table.getSelectionModel().getSelectedItem().getNrp()));
        nama.setText(table.getSelectionModel().getSelectedItem().getNama());
        ipa.setText(String.valueOf(table.getSelectionModel().getSelectedItem().getIpa()));
        ips.setText(String.valueOf(table.getSelectionModel().getSelectedItem().getIps()));
    }
    @FXML
    protected void addStudent() {
        int sNrp = Integer.parseInt(nrp.getText());
        String sName = nama.getText();
        float sIpa = Float.parseFloat(ipa.getText());
        float sIps = Float.parseFloat(ips.getText());
        sList.add(new Student(sNrp, sName, sIpa, sIps));
        reset();
    }
    @FXML
    protected void updateStudent() {
        int sNrp = Integer.parseInt(nrp.getText());
        String sName = nama.getText();
        float sIpa = Float.parseFloat(ipa.getText());
        float sIps = Float.parseFloat(ips.getText());
        sList.set(idx, new Student(sNrp, sName, sIpa, sIps));
        reset();
    }
    @FXML
    protected void delStudent() {
        int nrpDel = Integer.parseInt(nrp.getText());
        for (Student st: sList) {
            if (nrpDel == st.getNrp()) {
                sList.remove(st);
                break;
            }
        }
        reset();
    }
}