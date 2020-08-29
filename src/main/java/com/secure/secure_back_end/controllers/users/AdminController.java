package com.secure.secure_back_end.controllers.users;

import com.secure.secure_back_end.dto.user.view.UserViewModel;
import com.secure.secure_back_end.services.interfaces.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@Validated
public class AdminController
{
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/admins/all-users")
    @ApiOperation(value = "returns all of the users currently registered")
    public List<UserViewModel> getAllUsers()
    {
        return this.userService.getAllUsers();
    }

    @PutMapping("/admins/user-authority")
    @ApiOperation(value = "Changes authority by Id @RequestParams are \"userId\" and \"authorityId\". Example PUT /admins/user-authority?userId=1&authorityId=2")
    public void changeAuthority(@RequestParam("userId") @Min(1) Long userId,
                                @RequestParam("authorityId") @Min(1) Long authorityId)
    {
        this.userService.changeUserRole(authorityId, userId);
    }

    @PutMapping("/admins/user-account")
    @ApiOperation(value = " Locks user account by Id. @RequestParams are \"action\" and \"id\" .Action can be \"lock\" or \"unlock\". Example GET /admins/account?action=lock&id=1")
    public void lockAccount(@RequestParam("action") @Pattern(regexp = "^lock$|^unlock$") String action,
                            @RequestParam("userId") @Min(1) Long id)
    {
        this.userService.lockAccountAdmin(action, id);
    }
}
