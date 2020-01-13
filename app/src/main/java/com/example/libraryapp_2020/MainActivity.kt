package com.example.libraryapp_2020

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.book_ticket.view.*

class MainActivity : AppCompatActivity() {
var  adapter:bookAdapter?= null
    var listOfbooks = ArrayList<book>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        //load books
        listOfbooks.add(
            book(
                "Adventures",
                " Harry Potter and the Deathly Hallows is a fantasy novel written by British author J. K. Rowling and the seventh and final novel of the Harry Potter series. It was released on 21 July 2007 in the United Kingdom by Bloomsbury Publishing, in the United States by Scholastic, and in Canada by Raincoast Books. The novel chronicles the events directly following Harry Potter and the Half-Blood Prince (2005) and the final confrontation between the wizards Harry Potter and Lord Voldemort. ",
                R.drawable.harryporter
            )
        )
        listOfbooks.add(
            book(
                "Smart",
                " It's never too soon or too late to improve your study skills. With this book, you get Thirty-three Principles to help improve your studies and testing. “How To Study Smart” can be read in a couple of evenings but the information can impact a lifetime. “How To Study Smart!” This is the book you're looking for. ",
                R.drawable.howtostudysmart
            )
        )
        listOfbooks.add(
            book(
                "Tales",
                "Parents need to know that The Girl the Sea Gave Back is a Viking warrior fantasy from the same world as Sky in the Deep, but it takes place about 10 years later. A few of the same characters show up, but they have no major role to play, so either book can be read first. As in that novel, the battles and skirmishes are extra bloody here. Expect close-up details of gory action: throats slit with knives, the pop of a knife plunging into a chest, axes digging into flesh, etc. Many die, including a few secondary characters who are heavily mourned and burned on pyres. Many are also wounded, with details about blood loss, infections, and stitching deep cuts. A whole village of innocents is slaughtered, with details of the aftermath (seeing children dead in mothers' arms). A head is chopped off a corpse and carried away. Characters (including teens) drink mead and wine at meals and before and after battle. The main characters are admirable: Tova finally listens to her intuition and escapes her old life to right wrongs, and Halvard grows into the leader his people need in a crisis, one who ultimately chooses peace, even though it's harder to achieve. ",
                R.drawable.thegirltheseagaveback
            )
        )
        listOfbooks.add(
            book(
                "Earth",
                " Connor in his scrawled upon school shirt, the sun in his eyes. ... Ryan owned a book called The Journey To Eden that was written by Connor Penrose, published ",
                R.drawable.thesuninhiseyes
            )
        )
        listOfbooks.add(
            book(
                "Birds",
                "A teacher at a New England prep school ignites a gender war—with deadly consequences—in this dark and provocative novel by the bestselling author of The Passenger ",
                R.drawable.theswallows
            )
        )
        listOfbooks.add(
            book(
                "Strategy",
                " Want to improve at chess? Then you'll need to improve your understanding of chess strategy. You probably knew that already - but how to begin to study such a vast and seemingly complex subject? International Master Adam Hunt is a full-time chess teacher and is thus very familiar with this problem. His solution is to present an accessible and easy-to-read guide for club players and juniors. Hunt studies all the key components of chess strategy, including development, king safety, attack and defence, initiative, pawn play and much more. He examines not only grandmaster games but also those played by students, demonstrates model strategic play, identifies typical mistakes and explains how to avoid them. Move by Move provides an ideal platform to study chess. By continually challenging the reader to answer probing questions throughout the book, the Move by Move format greatly encourages the learning and practising of vital skills just as much as the traditional assimilation of knowledge. Carefully selected questions and answers are designed to keep you actively involved and allow you to monitor your progress as you learn. This is an excellent way to improve your chess skills and knowledge. ",
                R.drawable.strategy
            )
        )
      adapter= bookAdapter(this,listOfbooks)

        gvListbook.adapter = adapter


    }

      class bookAdapter:BaseAdapter{

          var listOfbooks = ArrayList<book>()
          var context:Context?=null
          constructor(context: Context,listOfbooks:ArrayList<book>):super(){


              this.listOfbooks = listOfbooks
              this.context = context
          }

          override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
              val books = this.listOfbooks [p0]
              var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
              var bookView= inflator.inflate(R.layout.book_ticket,null)


              bookView.ivbookimage.setImageResource(books.image!!)


              bookView.tvbook.text=books.name
              bookView.ivbookimage.setOnClickListener {

                  val intent = Intent(context,book_details::class.java)
                  intent.putExtra("name",books.name!!)
                  intent.putExtra("des",books.des!!)
                  intent.putExtra("image",books.image!!)
                  context!!.startActivity(intent)
              }




              return  bookView

          }
          override fun getItem(p0: Int): Any {
              return listOfbooks[p0]
          }

          override fun getItemId(p0: Int): Long {
              return p0.toLong()
          }

          override fun getCount(): Int {

              return listOfbooks.size
          }

      }
}
