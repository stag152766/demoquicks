package com.example.demo.validations;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;


import java.util.HashMap;
import java.util.Map;

/* Сервис, возвращающий мап с ошибками
 */
@Service
public class ResponseErrorValidation {

    // BindingResult приходит из validation framework, содержащий ошибки (н-р, пустой пароль)
    public ResponseEntity<Object> mapValidationService(BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            // проверка за объекты
            if (!CollectionUtils.isEmpty(result.getAllErrors())){
                for (ObjectError error: result.getAllErrors() ){
                    errorMap.put(error.getCode(), error.getDefaultMessage());
                }
            }

            // проверка за атрибуты
            for (FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            // если были ошибки, возвращаем и дальше не идем
            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);

        }
        // это хорошо
        return null;

    }

}
