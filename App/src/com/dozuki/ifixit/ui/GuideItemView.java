package com.dozuki.ifixit.ui;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dozuki.ifixit.MainApplication;
import com.dozuki.ifixit.R;
import com.dozuki.ifixit.model.guide.GuideInfo;
import com.dozuki.ifixit.util.ImageSizes;
import com.squareup.picasso.Picasso;

public class GuideItemView extends RelativeLayout {
   private TextView mTitleView;
   private ImageView mThumbnail;
   private Context mContext;

   public GuideItemView(Context context) {
      super(context);
      mContext = context;

      LayoutInflater.from(mContext).inflate(R.layout.guide_grid_item, this, true);

      mTitleView = (TextView)findViewById(R.id.guide_grid_item_title);
      mThumbnail = (ImageView)findViewById(R.id.guide_grid_item_thumbnail);
   }

   public void setGuideItem(GuideInfo guide) {
      ImageSizes imageSizes = MainApplication.get().getImageSizes();

      mTitleView.setText(guide.hasSubject() ? guide.mSubject : Html.fromHtml(guide.mTitle));

      if (guide.hasImage()) {
         // Clear image before setting it to make sure the old image isn't the background while the new one is loading
         mThumbnail.setImageDrawable(null);

         Picasso.with(mContext)
          .load(guide.getImagePath(imageSizes.getGrid()))
          .error(R.drawable.no_image)
          .into(mThumbnail);
      }
   }
}