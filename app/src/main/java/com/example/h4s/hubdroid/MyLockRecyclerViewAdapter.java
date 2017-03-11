package com.example.h4s.hubdroid;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.h4s.hubdroid.LockFragment.OnListFragmentInteractionListener;
import com.example.h4s.hubdroid.dummy.DummyContent.LockItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link LockItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyLockRecyclerViewAdapter extends RecyclerView.Adapter<MyLockRecyclerViewAdapter.ViewHolder> {

    private final List<LockItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyLockRecyclerViewAdapter(List<LockItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_lock, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);
        if(mValues.get(position).isLocked) {
            holder.lockButton.setImageResource(R.drawable.ic_lock_open_black_24dp);
        } else {
            holder.lockButton.setImageResource(R.drawable.ic_lock_outline_black_24dp);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public final ImageButton lockButton;

        public LockItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
            lockButton = (ImageButton) view.findViewById(R.id.lockbutton);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
