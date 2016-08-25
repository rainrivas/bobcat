/*-
 * #%L
 * Bobcat
 * %%
 * Copyright (C) 2016 Cognifide Ltd.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.cognifide.qa.bb.aem.touch.siteadmin.aem62;

import com.cognifide.qa.bb.aem.touch.siteadmin.common.PageActivationStatus;
import com.cognifide.qa.bb.aem.touch.siteadmin.common.ActivationStatus;
import com.cognifide.qa.bb.constants.Timeouts;
import com.cognifide.qa.bb.qualifier.CurrentScope;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.cognifide.qa.bb.utils.WebElementUtils;
import com.google.inject.Inject;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class PageActivationStatusImpl implements PageActivationStatus {

  @CurrentScope
  @Inject
  private WebElement currentScope;

  @Inject
  private WebElementUtils elementUtils;

  @FindBy(css = "coral-icon.coral-Icon--pending")
  private WebElement scheduledIcon;

  @Override public String getReplicationActionDate() {
    throw new NotImplementedException("Not implemented yet");
  }

  @Override public String getReplicationActionUser() {
    throw new NotImplementedException("Not implemented yet");
  }

  @Override public ActivationStatus getActivationStatus() {
    if (elementUtils.isDisplayed(scheduledIcon, Timeouts.MINIMAL)) {
      return ActivationStatus.SCHEDULED;
    }
    if (currentScope.getAttribute("value").equals("0")) {
      return ActivationStatus.NOT_PUBLISHED;
    }
    return ActivationStatus.PUBLISHED;
  }
}