package com.example.odev5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.example.odev5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupNumberButtons();
        setupOperatorButtons();
        setupActionButtons();
    }

    private void setupNumberButtons() {
        binding.btnSifir.setOnClickListener(v -> appendToInput("0"));
        binding.btnBir.setOnClickListener(v -> appendToInput("1"));
        binding.btniki.setOnClickListener(v -> appendToInput("2"));
        binding.btnUc.setOnClickListener(v -> appendToInput("3"));
        binding.btnDort.setOnClickListener(v -> appendToInput("4"));
        binding.btnBes.setOnClickListener(v -> appendToInput("5"));
        binding.btnAlti.setOnClickListener(v -> appendToInput("6"));
        binding.btnYedi.setOnClickListener(v -> appendToInput("7"));
        binding.btnSekiz.setOnClickListener(v -> appendToInput("8"));
        binding.btnDokuz.setOnClickListener(v -> appendToInput("9"));
        binding.btnNokta.setOnClickListener(v -> appendToInput("."));
    }

    private void setupOperatorButtons() {
        binding.btnArti.setOnClickListener(v -> appendToInput("+"));
    }

    private void setupActionButtons() {
        binding.btnSil.setOnClickListener(v -> removeLastCharacter());
        binding.btnTemiz.setOnClickListener(v -> clearInput());
        binding.btnEsit.setOnClickListener(v -> performCalculation());
    }

    private void appendToInput(String value) {
        binding.textCikis.setText("");
        binding.textGiris.append(value);
    }

    private void removeLastCharacter() {
        TextView tvInput = binding.textGiris;
        CharSequence currentText = tvInput.getText();
        if (currentText.length() > 0) {
            tvInput.setText(currentText.subSequence(0, currentText.length() - 1));
        }
    }

    private void clearInput() {
        binding.textGiris.setText("");
    }

    private void performCalculation() {
        TextView textGiris = binding.textGiris;
        TextView textCikis = binding.textCikis;

        String inputString = textGiris.getText().toString();
        String[] numbers = inputString.split("\\+");

        double sum = 0;

        for (String number : numbers) {
            try {
                double splitNumber = Double.parseDouble(number.trim());
                sum += splitNumber;
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Geçersiz sayı formatı: " + number, Toast.LENGTH_SHORT).show();
                return;
            }
        }
        textCikis.setText(String.valueOf(sum));
    }
}
