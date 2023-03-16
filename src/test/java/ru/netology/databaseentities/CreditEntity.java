package ru.netology.databaseentities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreditEntity {
    String id;
    String bank_id;
    String created;
    String status;
}
