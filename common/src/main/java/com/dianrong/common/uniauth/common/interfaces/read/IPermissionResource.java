package com.dianrong.common.uniauth.common.interfaces.read;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dianrong.common.uniauth.common.bean.Response;
import com.dianrong.common.uniauth.common.bean.dto.PermTypeDto;
import com.dianrong.common.uniauth.common.bean.dto.PermissionDto;
import com.dianrong.common.uniauth.common.bean.dto.RoleDto;
import com.dianrong.common.uniauth.common.bean.request.PermissionParam;
import com.dianrong.common.uniauth.common.bean.request.PermissionQuery;

@Path("permission")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public interface IPermissionResource {

    @GET
    @Path("allpermtypecodes")
    //scenario: get all permission type codes, dictionary data from perm_type table
    Response<List<PermTypeDto>> getAllPermTypeCodes();
	
    @POST
    @Path("searchperms")
    //scenario: search permissions
    Response<List<PermissionDto>> searchPerm(PermissionQuery permissionQuery);
    
    @POST
    @Path("roles")
    //scenario: retrieve all roles connected with a permission(including all other roles under a domain)
    Response<List<RoleDto>> getAllRolesToPerm(PermissionParam permissionParam);
}
