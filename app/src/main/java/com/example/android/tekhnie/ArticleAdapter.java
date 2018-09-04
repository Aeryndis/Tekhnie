package com.example.android.tekhnie;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ArticleAdapter extends ArrayAdapter<Article> {

    /**
     * The part of the time string that separates the date from the time
     */
    private static final String TIME_SEPARATOR = "T";

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param articles       A List of Article objects to display in a list
     */
    public ArticleAdapter(Activity context, ArrayList<Article> articles) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for three TextViews the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, articles);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position      The position in the list of data that should be displayed in the
     *                      list item view.
     * @param convertView   The recycled view to populate.
     * @param parent        The parent ViewGroup that is used for inflation.
     * @return              The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.article_list_item, parent, false);
        }

        // Get the {@Link Article} object located at this position in the list
        Article currentArticle = getItem(position);

        // Fetch and display the relevant data in the correct text views
        TextView articleTitleTextView = listItemView.findViewById(R.id.article_title);
        articleTitleTextView.setText(currentArticle.getArticleTitle());

        TextView articleBylineTextView = listItemView.findViewById(R.id.article_byline);
        articleBylineTextView.setText(currentArticle.getArticleByline());

        TextView sectionTextView = listItemView.findViewById(R.id.section_name);
        sectionTextView.setText(currentArticle.getArticleSection());

        TextView articleDateTextView = listItemView.findViewById(R.id.date);
        // Fetch the full date string and split the date from the time
        String rawDate = currentArticle.getArticleDate();
        String[] parts = rawDate.split(TIME_SEPARATOR);
        String truncatedDate = parts[0];
        articleDateTextView.setText(truncatedDate);

        return listItemView;
    }

}
