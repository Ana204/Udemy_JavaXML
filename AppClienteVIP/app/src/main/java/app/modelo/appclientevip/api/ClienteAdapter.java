package app.modelo.appclientevip.api;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.modelo.appclientevip.R;
import app.modelo.appclientevip.model.Cliente;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ViewHolder> {

    private List<Cliente> aClientes; //Lista de clientes do adapter
    private Context aContext;

    public ClienteAdapter(List<Cliente> aClientes, Context aContext) {
        this.aClientes = aClientes;
        this.aContext = aContext;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View clienteView = inflater.inflate(R.layout.activity_detalhes_clientes, parent, false);
        ViewHolder viewHolder = new ViewHolder(clienteView);

        return viewHolder;
    }

    //popular
    @Override
    public void onBindViewHolder(@NonNull ClienteAdapter.ViewHolder holder, int position) {

        Cliente objDaLinha = aClientes.get(position);

        TextView primeiroNome = holder.rvPrimeiroNome;
        primeiroNome.setText(objDaLinha.getPrimeiroNome());

        Button btnPessoa = holder.rvPessoa;
        btnPessoa.setText(objDaLinha.isPessoaFisica() ? "CPF" : "CNPJ");

    }

    @Override
    public int getItemCount() {
        return aClientes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView rvPrimeiroNome;
        public Button rvPessoa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rvPrimeiroNome = itemView.findViewById(R.id.rvPrimeiroNome);
            rvPessoa = itemView.findViewById(R.id.rvPessoa);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();

            Cliente clienteSelecionado = aClientes.get(position);

            if (position != RecyclerView.NO_POSITION){


                Log.i(AppUtil.LOG_APP, "Cliente ID" + position + "Primeiro Nome: " +clienteSelecionado.getPrimeiroNome());

                Toast.makeText(aContext, "Cliente ID" + position + "Primeiro Nome: " +clienteSelecionado.getPrimeiroNome(), Toast.LENGTH_LONG).show();
            }

        }
    }
}