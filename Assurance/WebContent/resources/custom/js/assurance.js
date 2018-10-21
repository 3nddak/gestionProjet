function handleLoginRequest(xhr, status, args) {
    if (args.validationFailed || !args.op) {
        PF('changer_interface').jq.effect("shake", {times: 5}, 100);
    } else {
        PF('changer_interface').hide();
        $('#loginLink').fadeOut();
    }
}
                        