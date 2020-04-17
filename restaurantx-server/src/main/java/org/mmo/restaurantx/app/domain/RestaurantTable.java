package org.mmo.restaurantx.app.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "restaurant_tables", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"table_number"})
})
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id")
    private Integer tableId;
    
    @Column(name = "table_number")
    @NotBlank
    @NotNull
    private String tableNumber;
    
    @Column(name = "table_description")
    private String tableDesc;
    
    @Column(name = "max_number_of_persons")
    @Min(0)
    private int maxNoOfPersons;
    
    public RestaurantTable() {
    }
    
    public RestaurantTable(@NotBlank @NotNull String tableNumber, String tableDesc, @Min(0) @NotNull int maxNoOfPersons) {
        this.tableNumber = tableNumber;
        this.tableDesc = tableDesc;
        this.maxNoOfPersons = maxNoOfPersons;
    }
    
    public Integer getTableId() {
        return tableId;
    }
    
    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }
    
    public String getTableNumber() {
        return tableNumber;
    }
    
    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }
    
    public String getTableDesc() {
        return tableDesc;
    }
    
    public void setTableDesc(String tableDesc) {
        this.tableDesc = tableDesc;
    }
    
    public int getMaxNoOfPersons() {
        return maxNoOfPersons;
    }
    
    public void setMaxNoOfPersons(int maxNoOfPersons) {
        this.maxNoOfPersons = maxNoOfPersons;
    }
    
}
