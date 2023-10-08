package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var urlRepositorieShare : (String) -> Unit ={}
    var urlRepositorieOpen : (String) -> Unit ={}


    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            nomeRepositorio.text = repositories[position].name

            btnShare.setOnClickListener{
                urlRepositorieShare(repositories[position].htmlUrl)
            }

            listRepositories.setOnClickListener{
                urlRepositorieOpen(repositories[position].htmlUrl)
            }
        }
    }

    // Pega a quantidade de repositorios da lista
    override fun getItemCount(): Int = repositories.size
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nomeRepositorio : TextView
        val btnShare : ImageView
        val listRepositories : CardView

        init{
            view.apply {
                nomeRepositorio = findViewById(R.id.tv_repositorie_name)
                btnShare = findViewById(R.id.iv_share)
                listRepositories = findViewById(R.id.cv_repositorie)
            }
        }
   }
}


