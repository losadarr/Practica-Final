package com.example.demo.repository;

@Table("TURBINAS")

public class Turbinas {

private @Column("ID") @Id Long id;
private @Column("FIELD1") String field1;
private @Column("FIELD2") BigDecimal field2;
private @Column("MY_DATE") LocalDate date;
private @Column("MY_TIME") LocalTime time;
private @Column("FLAG") Boolean flag;
}
