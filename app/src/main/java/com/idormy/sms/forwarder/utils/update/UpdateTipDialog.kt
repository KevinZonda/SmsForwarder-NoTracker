package com.idormy.sms.forwarder.utils.update

import android.content.DialogInterface
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.idormy.sms.forwarder.R
import com.idormy.sms.forwarder.utils.CommonUtils.Companion.goWeb
import com.xuexiang.xui.utils.ResUtils
import com.xuexiang.xui.widget.dialog.DialogLoader

/**
 * 版本更新提示弹窗
 *
 * @author xuexiang
 * @since 2019-06-15 00:06
 */
class UpdateTipDialog : AppCompatActivity(), DialogInterface.OnDismissListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var content = intent.getStringExtra(KEY_CONTENT)
        if (TextUtils.isEmpty(content)) {
            content = String.format(ResUtils.getString(R.string.download_slow_switch_download_url), DOWNLOAD_TYPE_NAME)
        }
        DialogLoader.getInstance()
            .showConfirmDialog(this, content, ResUtils.getString(R.string.yes), { dialog: DialogInterface, _: Int ->
                dialog.dismiss()
                goWeb(this@UpdateTipDialog, DOWNLOAD_URL)
            }, ResUtils.getString(R.string.no))
            .setOnDismissListener(this)
    }

    override fun onDismiss(dialog: DialogInterface) {
        finish()
    }

    companion object {
        const val KEY_CONTENT = "com.idormy.sms.forwarder.utils.update.KEY_CONTENT"

        // 填写你应用下载类型名
        const val DOWNLOAD_TYPE_NAME = "酷安"

        // 填写你应用下载页面的链接
        private const val DOWNLOAD_URL = "https://www.coolapk.com/apk/com.idormy.sms.forwarder"

        /**
         * 显示版本更新重试提示弹窗
         *
         * @param content
         */
        @JvmStatic
        fun show(content: String?) {
        }
    }
}