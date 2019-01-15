package configure.test.configurebuilds.activities.test108;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import configure.test.configurebuilds.R;

public class Adapter108 extends RecyclerView.Adapter<Adapter108.ViewHolder> {

    private List<Item108> mItem108List;

    public Adapter108(List<Item108> mItem108List) {
        this.mItem108List = mItem108List;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.single_item_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Item108 item108 = this.mItem108List.get(position);
        viewHolder.mTitle.setText(item108.mTitle);
    }

    @Override
    public int getItemCount() {
        return this.mItem108List.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private View mView;
        private TextView mTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            mTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
