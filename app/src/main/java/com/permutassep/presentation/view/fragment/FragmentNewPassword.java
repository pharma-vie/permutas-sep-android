package com.permutassep.presentation.view.fragment;

/**
 * By Jorge E. Hernandez (@lalongooo) 2015
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.lalongooo.permutassep.R;
import com.permutassep.config.Config;
import com.permutassep.presentation.internal.di.components.ApplicationComponent;
import com.permutassep.presentation.internal.di.components.AuthenticationComponent;
import com.permutassep.presentation.internal.di.components.DaggerAuthenticationComponent;
import com.permutassep.presentation.model.ConfirmPasswordResetDataWrapperModel;
import com.permutassep.presentation.presenter.NewPasswordPresenter;
import com.permutassep.presentation.view.LoginView;
import com.permutassep.presentation.view.NewPasswordView;
import com.permutassep.presentation.view.activity.BaseActivity;
import com.throrinstudio.android.common.libs.validator.Form;
import com.throrinstudio.android.common.libs.validator.Validate;
import com.throrinstudio.android.common.libs.validator.validator.LengthValidator;
import com.throrinstudio.android.common.libs.validator.validator.NotEmptyValidator;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentNewPassword extends BaseFragment implements NewPasswordView {


    @Bind(R.id.etPasswordOne)
    EditText etPasswordOne;
    @Bind(R.id.etPasswordTwo)
    EditText etPasswordTwo;
    @Bind(R.id.btnResetPassword)
    TextView btnResetPassword;

    /**
     * UI elements
     */

    @Inject
    NewPasswordPresenter newPasswordPresenter;

    private Form form;
    private MaterialDialog progressDialog;

    /**
     * Empty constructor
     */
    public FragmentNewPassword() {
        super();
    }

    /**
     * A static method to create a new instance of the {@link FragmentNewPassword} class
     *
     * @return An instance of {@link FragmentNewPassword}
     */
    public static FragmentNewPassword newInstance() {
        return new FragmentNewPassword();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.ca_fragment_new_password, container, false);
        ButterKnife.bind(this, fragmentView);

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        setUI();
        initializeInjector();

        return fragmentView;
    }

    private void setUI() {

        Validate vPasswordOne = new Validate(etPasswordOne);
        vPasswordOne.addValidator(new NotEmptyValidator(getActivity()));
        vPasswordOne.addValidator(new LengthValidator(getActivity(), R.string.new_password_password_length_error, Config.PASSWORD_MIN_LENGTH, Config.PASSWORD_MAX_LENGTH));

        Validate vPasswordTwo = new Validate(etPasswordTwo);
        vPasswordTwo.addValidator(new NotEmptyValidator(getActivity()));
        vPasswordTwo.addValidator(new LengthValidator(getActivity(), R.string.new_password_password_length_error, Config.PASSWORD_MIN_LENGTH, Config.PASSWORD_MAX_LENGTH));

        form = new Form();
        form.addValidates(vPasswordOne);
        form.addValidates(vPasswordTwo);
    }

    private void initializeInjector() {
        AuthenticationComponent authenticationComponent =
                DaggerAuthenticationComponent.builder()
                        .applicationComponent(getComponent(ApplicationComponent.class))
                        .activityModule(((BaseActivity) getActivity()).getActivityModule())
                        .build();
        authenticationComponent.inject(this);
        this.newPasswordPresenter.setView(this);
    }


    @OnClick(R.id.btnResetPassword)
    void onBtnResetPasswordClick() {
        if (form.isValid()) {

            String token = getActivity().getIntent().getStringExtra(Config.PWD_RESET_TOKEY_KEY);
            String password = etPasswordOne.getText().toString();
            String passwordConfirm = etPasswordTwo.getText().toString();

            ConfirmPasswordResetDataWrapperModel confirmPasswordResetDataWrapperModel =
                    new ConfirmPasswordResetDataWrapperModel(token, password, passwordConfirm);
            newPasswordPresenter.confirmPasswordReset(confirmPasswordResetDataWrapperModel);
        }
    }

    /**
     * Methods from the {@link LoginView} interface
     */

    @Override
    public void passwordCorrectlyReset() {

    }

    @Override
    public void showLoading() {
        progressDialog = new MaterialDialog.Builder(getActivity())
                .title(R.string.app_login_dlg_login_title)
                .content(R.string.app_login_dlg_login_logging_in)
                .progress(true, 0)
                .progressIndeterminateStyle(false)
                .show();
    }


    @Override
    public void hideLoading() {
        if (progressDialog != null)
            progressDialog.dismiss();
    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {
        this.showToastMessage(message);
    }

}